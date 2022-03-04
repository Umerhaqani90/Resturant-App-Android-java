package com.restaurent.myrestaurent.model;

import android.widget.ImageView;

public class ReviewModel {
    int imgReviewPerson;
    String reviewerName, reviewerTableDetail, reviewerAddress , txtReview;

    public ReviewModel(int imgReviewPerson, String reviewerName, String reviewerTableDetail, String reviewerAddress, String txtReview) {
        this.imgReviewPerson = imgReviewPerson;
        this.reviewerName = reviewerName;
        this.reviewerTableDetail = reviewerTableDetail;
        this.reviewerAddress = reviewerAddress;
        this.txtReview = txtReview;
    }

    public int getImgReviewPerson() {
        return imgReviewPerson;
    }

    public void setImgReviewPerson(int imgReviewPerson) {
        this.imgReviewPerson = imgReviewPerson;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewerTableDetail() {
        return reviewerTableDetail;
    }

    public void setReviewerTableDetail(String reviewerTableDetail) {
        this.reviewerTableDetail = reviewerTableDetail;
    }

    public String getReviewerAddress() {
        return reviewerAddress;
    }

    public void setReviewerAddress(String reviewerAddress) {
        this.reviewerAddress = reviewerAddress;
    }

    public String getTxtReview() {
        return txtReview;
    }

    public void setTxtReview(String txtReview) {
        this.txtReview = txtReview;
    }
}
