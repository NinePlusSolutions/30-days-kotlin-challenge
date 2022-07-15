package com.example.rcvviewmodellivedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {
    private MutableLiveData<List<User>> mListUserLiveData;
    private List<User> mListUser;

    public UserViewModel() {
        mListUserLiveData = new MutableLiveData<>();
        initData();
    }

    private void initData() {
        mListUser = new ArrayList<>();
        mListUser.add(new User(R.drawable.anh5,"duong","dep trai"));
        mListUserLiveData.setValue(mListUser);
    }

    public MutableLiveData<List<User>> getListUserLiveData() {
        return mListUserLiveData;
    }
    public void addUser(User user){
        mListUser.add(user);
        mListUserLiveData.setValue(mListUser);
    }
}
