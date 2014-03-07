package com.leashin.test;

import com.leashin.imagecropper.ImageCropper;
import com.leashin.imagecropper.R;
import com.leashin.imagecropper.util.PixelUtils;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	public static final String TAG = "MainActivity";

	private ImageCropper mTestPv;
	private ImageView mCropIv;
	private Button mChooseBtn;

	// private int mClickCounter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTestPv = (ImageCropper) findViewById(R.id.pv_test);
		mCropIv = (ImageView) findViewById(R.id.iv_crop);
		mChooseBtn = (Button) findViewById(R.id.btn_choose);

		mCropIv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mCropIv.setVisibility(View.GONE);
			}
		});

		mChooseBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Bitmap bitmap = mTestPv.getCropImage();
				if (bitmap == null)
					return;
				mCropIv.setImageBitmap(bitmap);
				mCropIv.setVisibility(View.VISIBLE);

				// if (mClickCounter++ % 2 == 0) {
				// mTestPv.setCropperSize(
				// PixelUtils.dp2px(getBaseContext(), 240),
				// PixelUtils.dp2px(getBaseContext(), 300));
				// } else {
				// mTestPv.setCropperMargin(PixelUtils.dp2px(getBaseContext(),
				// 48));
				// }
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
