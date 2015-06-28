package com.example.smsblocker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {

	public static final String TAG = "SMSReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		Object[] pdus = (Object[]) bundle.get("pdus");

		SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[0]);

		String messageText = message.getMessageBody();
		Log.i(TAG, messageText);

		if (messageText.contains("Tes")) {
			abortBroadcast();
		}
	}

}
