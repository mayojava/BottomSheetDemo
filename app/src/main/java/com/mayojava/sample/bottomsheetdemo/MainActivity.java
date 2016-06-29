package com.mayojava.sample.bottomsheetdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.button_show_bottom_sheet) Button mButtonShowBottomSheet;
    @BindView(R.id.button_collapse_bottom_sheet) Button mCollapseBottomSheet;
    @BindView(R.id.button_hide_bottom_sheet) Button mHideBottomSheet;
    @BindView(R.id.button_show_bottom_sheet_dialog) Button mShowBottomSheetDialog;
    @BindView(R.id.layout_bottom_sheet) View mLayoutBottomSheet;
    @BindView(R.id.text_view_sheet_title) TextView mTextViewBottomSheet;

    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mBottomSheetBehavior = BottomSheetBehavior.from(mLayoutBottomSheet);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        mTextViewBottomSheet.setText(getString(R.string.text_showing_sheet_content));
                        break;
                    default:
                        mTextViewBottomSheet.setText(getString(R.string.text_pull_to_show_more));
                        break;

                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @OnClick(R.id.button_show_bottom_sheet)
    public void showBottomSheet() {
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @OnClick(R.id.button_collapse_bottom_sheet)
    public void collapseBottomSheet() {
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @OnClick(R.id.button_hide_bottom_sheet)
    public void hideBottomSheet() {
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }

    @OnClick(R.id.button_show_bottom_sheet_dialog)
    public void showBottomSheetDialog() {
        CustomBottomSheetDialog bottomSheetDialog = CustomBottomSheetDialog.getInstance();
        bottomSheetDialog.show(getSupportFragmentManager(), "Custom Bottom Sheet");
    }


}
