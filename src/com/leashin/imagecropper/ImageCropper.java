/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * leashin: 修改成头像切割控件
 *******************************************************************************/
package com.leashin.imagecropper;

import com.leashin.imagecropper.ImageCropperAttacher.OnMatrixChangedListener;
import com.leashin.imagecropper.ImageCropperAttacher.OnPhotoTapListener;
import com.leashin.imagecropper.ImageCropperAttacher.OnViewTapListener;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ImageCropper extends ImageView implements ICropper {

	private final ImageCropperAttacher mAttacher;

	public ImageCropper(Context context) {
		this(context, null);
	}

	public ImageCropper(Context context, AttributeSet attr) {
		this(context, attr, 0);
	}

	public ImageCropper(Context context, AttributeSet attr, int defStyle) {
		super(context, attr, defStyle);
		super.setScaleType(ScaleType.MATRIX);
		mAttacher = new ImageCropperAttacher(this);
	}

	@Override
	public void setPhotoViewRotation(float rotationDegree) {
		mAttacher.setPhotoViewRotation(rotationDegree);
	}

	@Override
	public boolean canZoom() {
		return mAttacher.canZoom();
	}

	@Override
	public RectF getDisplayRect() {
		return mAttacher.getDisplayRect();
	}

	@Override
	public Matrix getDisplayMatrix() {
		return mAttacher.getDrawMatrix();
	}

	@Override
	public boolean setDisplayMatrix(Matrix finalRectangle) {
		return mAttacher.setDisplayMatrix(finalRectangle);
	}

	@Override
	public float getMinimumScale() {
		return mAttacher.getMinimumScale();
	}

	@Override
	public float getMediumScale() {
		return mAttacher.getMediumScale();
	}

	@Override
	public float getMaximumScale() {
		return mAttacher.getMaximumScale();
	}

	@Override
	public float getScale() {
		return mAttacher.getScale();
	}

	@Override
	public void setAllowParentInterceptOnEdge(boolean allow) {
		mAttacher.setAllowParentInterceptOnEdge(allow);
	}

	@Override
	public void setMinimumScale(float minimumScale) {
		mAttacher.setMinimumScale(minimumScale);
	}

	@Override
	public void setMediumScale(float mediumScale) {
		mAttacher.setMediumScale(mediumScale);
	}

	@Override
	public void setMaximumScale(float maximumScale) {
		mAttacher.setMaximumScale(maximumScale);
	}

	@Override
	// setImageBitmap calls through to this method
	public void setImageDrawable(Drawable drawable) {
		super.setImageDrawable(drawable);
		if (null != mAttacher) {
			mAttacher.update();
		}
	}

	@Override
	public void setImageResource(int resId) {
		super.setImageResource(resId);
		if (null != mAttacher) {
			mAttacher.update();
		}
	}

	@Override
	public void setImageURI(Uri uri) {
		super.setImageURI(uri);
		if (null != mAttacher) {
			mAttacher.update();
		}
	}

	@Override
	public void setOnMatrixChangeListener(OnMatrixChangedListener listener) {
		mAttacher.setOnMatrixChangeListener(listener);
	}

	@Override
	public void setOnLongClickListener(OnLongClickListener l) {
		mAttacher.setOnLongClickListener(l);
	}

	@Override
	public void setOnPhotoTapListener(OnPhotoTapListener listener) {
		mAttacher.setOnPhotoTapListener(listener);
	}

	@Override
	public void setOnViewTapListener(OnViewTapListener listener) {
		mAttacher.setOnViewTapListener(listener);
	}

	@Override
	public void setScale(float scale) {
		mAttacher.setScale(scale);
	}

	@Override
	public void setScale(float scale, boolean animate) {
		mAttacher.setScale(scale, animate);
	}

	@Override
	public void setScale(float scale, float focalX, float focalY,
			boolean animate) {
		mAttacher.setScale(scale, focalX, focalY, animate);
	}

	@Override
	public void setZoomable(boolean zoomable) {
		mAttacher.setZoomable(zoomable);
	}

	@Override
	protected void onDetachedFromWindow() {
		mAttacher.cleanup();
		super.onDetachedFromWindow();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		drawCropper(canvas);
	}

	@Override
	public void drawCropper(Canvas canvas) {
		mAttacher.drawCropper(canvas);
	}

	@Override
	public Bitmap getCropImage() {
		return mAttacher.getCropImage();
	}

	@Override
	public void setCropperMargin(float margin) {
		mAttacher.setCropperMargin(margin);
	}

	@Override
	public void setCropperSize(float w, float h) {
		mAttacher.setCropperSize(w, h);
	}
}