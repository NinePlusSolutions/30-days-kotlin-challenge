package com.ngockhanh.recyclerview.inter;

import com.ngockhanh.recyclerview.model.User;

public interface IClickItemUserListener {
    void onClickItemUser(User user);

    void onLikedClickItemListener(User user,int position);
}
