package com.example.cameraxapp

import android.Manifest
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.ImageCapture
import androidx.camera.video.Recorder
import androidx.camera.video.Recording
import androidx.camera.video.VideoCapture
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import android.widget.Toast
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.core.Preview
import androidx.camera.core.CameraSelector
import android.util.Log
import androidx.camera.core.ImageCaptureException
import androidx.camera.video.FallbackStrategy
import androidx.camera.video.MediaStoreOutputOptions
import androidx.camera.video.Quality
import androidx.camera.video.QualitySelector
import androidx.camera.video.VideoRecordEvent
import androidx.core.content.PermissionChecker
import com.example.cameraxapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    private var imageCapture: ImageCapture? = null

    private var videoCapture: VideoCapture<Recorder>? = null
    private var recording: Recording? = null

    private lateinit var cameraExecutor: ExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // Yêu cầu quyền truy cập cho máy ảnh
        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS
            )
        }

        // Tạo sự kiện cho các button
        viewBinding.imageCaptureButton.setOnClickListener { takePhoto() }
        viewBinding.videoCaptureButton.setOnClickListener { captureVideo() }

        cameraExecutor = Executors.newSingleThreadExecutor()
    }

    private fun takePhoto() {
        // Nhận tham chiếu về trường hợp sử dụng chụp ảnh có thể sửa đổi
        val imageCapture = imageCapture ?: return

        // Tạo tên đóng dấu thời gian và mục MediaStore.
        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
            .format(System.currentTimeMillis())
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
            }
        }

        // Tạo đối tượng tùy chọn đầu ra chứa tệp + siêu dữ liệu
        val outputOptions = ImageCapture.OutputFileOptions
            .Builder(
                contentResolver,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                contentValues
            )
            .build()

        // Thiết lập trình nghe chụp ảnh, được kích hoạt sau khi ảnh có
        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(this),
            object : ImageCapture.OnImageSavedCallback {
                override fun onError(exc: ImageCaptureException) {
                    Log.e(TAG, "Photo capture failed: ${exc.message}", exc)
                }

                override fun
                        onImageSaved(output: ImageCapture.OutputFileResults) {
                    val msg = "Photo capture succeeded: ${output.savedUri}"
                    Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, msg)
                }
            }
        )
    }

    private fun captureVideo() {
        //Kiểm tra xem trường hợp sử dụng VideoCapture đã được tạo chưa: nếu chưa, không làm gì cả.
        val videoCapture = this.videoCapture ?: return
        //Tắt giao diện người dùng cho đến khi hành động yêu cầu được CameraX hoàn thành;
        // nó được bật lại bên trong VideoRecordListener đã đăng ký của chúng tôi trong các bước sau.
        viewBinding.videoCaptureButton.isEnabled = false
        //Nếu có một bản ghi đang hoạt động, hãy dừng nó lại và giải phóng bản ghi hiện tại recording.
        // Chúng tôi sẽ được thông báo khi tệp video đã chụp sẵn sàng để ứng dụng của chúng tôi sử dụng.
        val curRecording = recording
        if (curRecording != null) {
            // Stop the current recording session.
            curRecording.stop()
            recording = null
            return
        }

        // create and start a new recording session
        //Để bắt đầu ghi, chúng tôi tạo một phiên ghi mới.
        // Đầu tiên,tạo đối tượng nội dung video MediaStore dự định ,
        // với dấu thời gian hệ thống làm tên hiển thị (để có thể chụp nhiều video).
        val name = SimpleDateFormat(FILENAME_FORMAT, Locale.US)
            .format(System.currentTimeMillis())
        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, name)
            put(MediaStore.MediaColumns.MIME_TYPE, "video/mp4")
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                put(MediaStore.Video.Media.RELATIVE_PATH, "Movies/CameraX-Video")
            }
        }
        //Tạo một MediaStoreOutputOptions.Buildervới tùy chọn nội dung bên ngoài.
        val mediaStoreOutputOptions = MediaStoreOutputOptions
            .Builder(contentResolver, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
            //Đặt video đã tạo thành contentValuesvà MediaStoreOutputOptions.Buildertạo phiên bản của chúng tôi MediaStoreOutputOptions.
            .setContentValues(contentValues)
            .build()

        //Định cấu hình tùy chọn đầu ra cho Recordervà VideoCapture<Recorder>bật ghi âm :
        recording = videoCapture.output
            .prepareRecording(this, mediaStoreOutputOptions)
            //Bật Âm thanh trong bản ghi này
            .apply {
                if (PermissionChecker.checkSelfPermission(
                        this@MainActivity,
                        Manifest.permission.RECORD_AUDIO
                    ) ==
                    PermissionChecker.PERMISSION_GRANTED
                ) {
                    withAudioEnabled()
                }
            }
            //Bắt đầu bản ghi âm mới này và đăng ký một trình nghe lambda VideoRecordEvent.
            .start(ContextCompat.getMainExecutor(this)) { recordEvent ->
                when (recordEvent) {
                    //Khi thiết bị máy ảnh bắt đầu ghi yêu cầu, hãy chuyển đổi văn bản nút "Bắt đầu chụp" để nói "Dừng chụp".
                    is VideoRecordEvent.Start -> {
                        viewBinding.videoCaptureButton.apply {
                            text = getString(R.string.stop_capture)
                            isEnabled = true
                        }
                    }
                    //Khi quá trình ghi hiện hoạt hoàn tất,và chuyển nút "Dừng chụp" trở lại "Bắt đầu chụp" và bật lại:
                    is VideoRecordEvent.Finalize -> {
                        if (!recordEvent.hasError()) {
                            val msg = "Video capture succeeded: " +
                                    "${recordEvent.outputResults.outputUri}"
                            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT)
                                .show()
                            Log.d(TAG, msg)
                        } else {
                            recording?.close()
                            recording = null
                            Log.e(
                                TAG, "Video capture ends with error: " +
                                        "${recordEvent.error}"
                            )
                        }
                        viewBinding.videoCaptureButton.apply {
                            text = getString(R.string.start_capture)
                            isEnabled = true
                        }
                    }
                }
            }
    }

    private fun startCamera() {

        //Tạo một phiên bản của ProcessCameraProvider.
        // Điều này được sử dụng để ràng buộc vòng đời của máy ảnh với chủ sở hữu vòng đời.
        // Điều này giúp loại bỏ nhiệm vụ mở và đóng máy ảnh vì CameraX nhận biết được vòng đời.
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        //Thêm người nghe vào cameraProviderFuture.
        // Thêm một Runnableđối số như một. Thêm làm đối số thứ hai.
        // Điều này trả về một chạy trên luồng chính.ContextCompat.getMainExecutor()Executor
        cameraProviderFuture.addListener({
            // Used to bind the lifecycle of cameras to the lifecycle owner
            //Được sử dụng để ràng buộc vòng đời của máy ảnh với chủ sở hữu vòng đời
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            // Preview
            //gọi bản dựng trên nó, lấy nhà cung cấp bề mặt từ kính ngắm, sau đó đặt nó trên bản xem trước.
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(viewBinding.viewFinder.surfaceProvider)
                }
            val recorder = Recorder.Builder()
                .setQualitySelector(
                    QualitySelector.from(
                        Quality.HIGHEST,
                        FallbackStrategy.higherQualityOrLowerThan(Quality.SD)
                    )
                )
                .build()
            videoCapture = VideoCapture.withOutput(recorder)

            imageCapture = ImageCapture.Builder().build()

            /*
            val imageAnalyzer = ImageAnalysis.Builder().build()
                .also {
                    setAnalyzer(
                        cameraExecutor,
                        LuminosityAnalyzer { luma ->
                            Log.d(TAG, "Average luminosity: $luma")
                        }
                    )
                }
            */

            // Chọn camera sau làm mặc định
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                // Hủy liên kết các trường hợp sử dụng trước khi đóng lại
                cameraProvider.unbindAll()

                // Liên kết các trường hợp sử dụng với máy ảnh
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageCapture, videoCapture
                )

            } catch (exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(this))
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            baseContext, it
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

    companion object {
        private const val TAG = "CameraXApp"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS =
            mutableListOf(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults:
        IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //Kiểm tra xem mã yêu cầu có đúng không; bỏ qua nó nếu không.
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            //Nếu quyền được cấp, hãy gọi startCamera().
            if (allPermissionsGranted()) {
                startCamera()
                //Nếu quyền không được cấp  thông báo cho người dùng rằng quyền đó không được cấp
            } else {
                Toast.makeText(
                    this,
                    "Permissions not granted by the user.",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }
}