
public class Main  {
	public static void main(String[] args) {
		MayTinhCasioFx500 mfx500 = new MayTinhCasioFx500();
		MayTinhVinaCal500 vn500 = new MayTinhVinaCal500();
		
		System.out.println("Máy tính mfx500: " + mfx500.cong(5, 3));
		System.out.println("Máy tính mfx500: " + mfx500.tru(5, 3));
		System.out.println("Máy tính mfx500: " + mfx500.nhan(5, 3));
		System.out.println("Máy tính mfx500: " + mfx500.chia(5, 3));
		
		double[] arr = new double[] {1,52,30,4,15,6,70};
		double[] arr2 = new double[] {20,10,50,12,9,0};
		
		SapXepChen sxc = new SapXepChen();
		SapXepChon sxch = new SapXepChon();
		
		sxc.SapXepTang(arr);
		for( int i = 0; i < arr.length; i++) {
		
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
		sxch.SapXepGiam(arr2);
		for( int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+ ", ");
		}
		System.out.println();
		
		PhamMemMayTinh pmmt = new PhamMemMayTinh(); 
		System.out.println("Cộng: " + pmmt.cong(5,3));
		
		double[] arr3 = new double[] {1,2,6,3,0,10,21,12,8};
		pmmt.SapXepTang(arr3);
		for( int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + ", ");
		}
	}
}
