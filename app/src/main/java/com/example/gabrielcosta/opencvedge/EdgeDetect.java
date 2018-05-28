/*
package com.example.gabrielcosta.opencvedge;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class EdgeDetect {

    private final static String TAG = "EdgeDetect";

    public static List<MatOfPoint> findContours(Mat src){
        Mat img = src.clone();
        src.release();
        //find contours
        double ratio = getScaleRatio(img.size());
        int width = (int) (img.size().width / ratio);
        int height = (int) (img.size().height / ratio);
        Size newSize = new Size(width, height);
        Mat resizedImg = new Mat(newSize, CvType.CV_8UC4);
        Imgproc.resize(img, resizedImg, newSize);

        Imgproc.medianBlur(resizedImg, resizedImg, 5);

        Mat cannedImg = new Mat(newSize, CvType.CV_8UC1);
        Imgproc.Canny(resizedImg, cannedImg, 70, 200, 3, true);
        resizedImg.release();

        Imgproc.threshold(cannedImg, cannedImg, 200, 255, Imgproc.THRESH_OTSU);

        Mat dilatedImg = new Mat(newSize, CvType.CV_8UC1);
        Mat morph = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));
        Imgproc.dilate(cannedImg, dilatedImg, morph, new Point(-1, -1), 2, 1, new Scalar(1));
        cannedImg.release();
        morph.release();

        ArrayList<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        Imgproc.findContours(dilatedImg, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        hierarchy.release();

        Log.d(TAG, "contours found: " + contours.size());

        Collections.sort(contours, new Comparator<MatOfPoint>() {
            @Override
            public int compare(MatOfPoint o1, MatOfPoint o2) {
                return Double.valueOf(Imgproc.contourArea(o2)).compareTo(Imgproc.contourArea(o1));
            }
        });

        return contours;
    }

for(MatOfPoint contour: contours){
        MatOfPoint2f mat = new MatOfPoint2f(contour.toArray());
        double peri = Imgproc.arcLength(mat, true);
        MatOfPoint2f approx = new MatOfPoint2f();
        Imgproc.approxPolyDP(mat, approx, 0.02 * peri, true);

        Point[] points = approx.toArray();
        Log.d("SCANNER", "approx size " + points.length);

        if (points.length == 4) {
            Point[] spoints = CVProcessor.sortPoints(points);

            if (CVProcessor.insideArea(spoints, newSize)) {
                rectContour = contour;
                foundPoints = spoints;
                break;
            }
        }
    }

}
*/
