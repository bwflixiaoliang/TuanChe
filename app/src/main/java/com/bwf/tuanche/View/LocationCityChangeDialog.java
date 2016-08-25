package com.bwf.tuanche.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.bwf.tuanche.R;

/**
 * Created by lixiaoliang on 2016/8/25.
 * Description:
 */
public class LocationCityChangeDialog extends Dialog implements View.OnClickListener {
    private String cityName;
    private TextView tv_content;
    private Button btn_change,btn_goOn;
    private Context context;
    private DialogOnClickListener listener;
    public LocationCityChangeDialog(Context context,String cityName,DialogOnClickListener listener) {
        super(context);
        this.context = context;
        this.cityName = cityName;
        this.listener = listener;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.citychangedialog);
        tv_content = (TextView) findViewById(R.id.changeCity_tv_content);
        btn_change = (Button) findViewById(R.id.changeCity_btn_change);
        btn_goOn = (Button) findViewById(R.id.changeCity_btn_goOn);
        btn_change.setOnClickListener(this);
        btn_goOn.setOnClickListener(this);
        if(cityName!=null)tv_content.setText(String.format(context.getString(R.string.changeCity),cityName));
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.changeCity_btn_change:
                listener.changeCity();
                if(isShowing())dismiss();
                break;
            case R.id.changeCity_btn_goOn:
                if(isShowing())dismiss();
                break;
        }
    }
    public  interface DialogOnClickListener{
        void changeCity();
    }
}
