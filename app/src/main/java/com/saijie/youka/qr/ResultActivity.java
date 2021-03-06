package com.saijie.youka.qr;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.saijie.youka.R;
import com.saijie.youka.qr.zxing.decode.DecodeThread;

import java.io.UnsupportedEncodingException;


/**
 * 
 * @描述: ResultActivity 二维码扫描结果
 * @time 2016年12月7日10:10:41
 * @version 0.0.1
 */
public class ResultActivity extends Activity {

	private ImageView mResultImage;
	private TextView mResultText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.qr_code_capture_result);

		Bundle extras = getIntent().getExtras();

		mResultImage = (ImageView) findViewById(R.id.result_image);
		mResultText = (TextView) findViewById(R.id.result_text);

		if (null != extras) {
			int width = extras.getInt("width");
			int height = extras.getInt("height");

			LayoutParams lps = new LayoutParams(width, height);
			lps.topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());
			lps.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
			lps.rightMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());

			mResultImage.setLayoutParams(lps);

			String result = extras.getString("result");
			try {
				mResultText.setText(new String(result.getBytes("ISO-8859-1"), "GB2312").toString());
				//mResultText.setText(new String(result.getBytes("GB2312"), "GB2312").toString());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			Bitmap barcode = null;
			byte[] compressedBitmap = extras.getByteArray(DecodeThread.BARCODE_BITMAP);
			if (compressedBitmap != null) {
				barcode = BitmapFactory.decodeByteArray(compressedBitmap, 0, compressedBitmap.length, null);
				// Mutable copy:
				barcode = barcode.copy(Bitmap.Config.RGB_565, true);
			}
			mResultImage.setImageBitmap(barcode);
		}
	}
}
