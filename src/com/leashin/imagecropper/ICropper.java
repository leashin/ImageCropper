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

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

public interface ICropper {
	/**
	 * Returns true if the PhotoView is set to allow zooming of Photos.
	 *
	 * @return true if the PhotoView allows zooming.
	 */
	boolean canZoom();

	/**
	 * Gets the Display Rectangle of the currently displayed Drawable. The
	 * Rectangle is relative to this View and includes all scaling and
	 * translations.
	 *
	 * @return - RectF of Displayed Drawable
	 */
	RectF getDisplayRect();

	/**
	 * Sets the Display Matrix of the currently displayed Drawable. The
	 * Rectangle is considered relative to this View and includes all scaling and
	 * translations.
	 *
	 * @return - true if rectangle was applied successfully
	 */
	boolean setDisplayMatrix(Matrix finalMatrix);

	/**
	 * Gets the Display Matrix of the currently displayed Drawable. The
	 * Rectangle is considered relative to this View and includes all scaling and
	 * translations.
	 *
	 * @return - true if rectangle was applied successfully
	 */
	Matrix getDisplayMatrix();

	/**
	 * @return The current minimum scale level. What this value represents depends on the current {@link android.widget.ImageView.ScaleType}.
	 */
	float getMinimumScale();

	/**
	 * @return The current medium scale level. What this value represents depends on the current {@link android.widget.ImageView.ScaleType}.
	 */
	float getMediumScale();

	/**
	 * @return The current maximum scale level. What this value represents depends on the current {@link android.widget.ImageView.ScaleType}.
	 */
	float getMaximumScale();

	/**
	 * Returns the current scale value
	 *
	 * @return float - current scale value
	 */
	float getScale();

	/**
	 * Whether to allow the ImageView's parent to intercept the touch event when the photo is scroll to it's horizontal edge.
	 */
	void setAllowParentInterceptOnEdge(boolean allow);

	/**
	 * Sets the minimum scale level. What this value represents depends on the current {@link android.widget.ImageView.ScaleType}.
	 */
	void setMinimumScale(float minimumScale);

	/**
	 * Sets the middle scale level. What this value represents depends on the current {@link android.widget.ImageView.ScaleType}.
	 */
	void setMediumScale(float mediumScale);

	/**
	 * Sets the maximum scale level. What this value represents depends on the current {@link android.widget.ImageView.ScaleType}.
	 */
	void setMaximumScale(float maximumScale);

	/**
	 * Register a callback to be invoked when the Photo displayed by this view is long-pressed.
	 *
	 * @param listener - Listener to be registered.
	 */
	void setOnLongClickListener(View.OnLongClickListener listener);

	/**
	 * Register a callback to be invoked when the Matrix has changed for this
	 * View. An example would be the user panning or scaling the Photo.
	 *
	 * @param listener - Listener to be registered.
	 */
	void setOnMatrixChangeListener(
			ImageCropperAttacher.OnMatrixChangedListener listener);

	/**
	 * Register a callback to be invoked when the Photo displayed by this View
	 * is tapped with a single tap.
	 *
	 * @param listener - Listener to be registered.
	 */
	void setOnPhotoTapListener(ImageCropperAttacher.OnPhotoTapListener listener);

	/**
	 * Register a callback to be invoked when the View is tapped with a single
	 * tap.
	 *
	 * @param listener - Listener to be registered.
	 */
	void setOnViewTapListener(ImageCropperAttacher.OnViewTapListener listener);

	/**
	 * Changes the current scale to the specified value.
	 *
	 * @param scale - Value to scale to
	 */
	void setScale(float scale);

	/**
	 * Changes the current scale to the specified value.
	 *
	 * @param scale   - Value to scale to
	 * @param animate - Whether to animate the scale
	 */
	void setScale(float scale, boolean animate);

	/**
	 * Changes the current scale to the specified value, around the given focal point.
	 *
	 * @param scale   - Value to scale to
	 * @param focalX  - X Focus Point
	 * @param focalY  - Y Focus Point
	 * @param animate - Whether to animate the scale
	 */
	void setScale(float scale, float focalX, float focalY, boolean animate);

	/**
	 * Allows you to enable/disable the zoom functionality on the ImageView.
	 * When disable the ImageView reverts to using the FIT_CENTER matrix.
	 *
	 * @param zoomable - Whether the zoom functionality is enabled.
	 */
	void setZoomable(boolean zoomable);

	/**
	 * Enables rotation via PhotoView internal functions.
	 * Name is chosen so it won't collide with View.setRotation(float) in API since 11
	 *
	 * @param rotationDegree - Degree to rotate PhotoView by, should be in range 0 to 360
	 */
	void setPhotoViewRotation(float rotationDegree);

	/**
	 * 绘制选取框
	 * @param canvas
	 */
	void drawCropper(Canvas canvas);

	/**
	 * 得到选区内的bitmap
	 * @return 选区中的bitmap
	 */
	Bitmap getCropImage();

	/**
	 * 边框的边距值设置,会覆盖setCropperSize方法
	 * @param margin 边距值
	 */
	void setCropperMargin(float margin);

	/**
	 * 选区框的大小，居中显示，覆盖setCropperMargin方法
	 * @param w
	 * @param h
	 */
	void setCropperSize(float w, float h);
}
