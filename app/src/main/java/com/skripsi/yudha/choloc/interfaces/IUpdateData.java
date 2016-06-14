package com.skripsi.yudha.choloc.interfaces;

import com.skripsi.yudha.choloc.types.FriendInfo;
import com.skripsi.yudha.choloc.types.MessageInfo;


public interface IUpdateData {
	public void updateData(MessageInfo[] messages, FriendInfo[] friends, FriendInfo[] unApprovedFriends, String userKey);

}
