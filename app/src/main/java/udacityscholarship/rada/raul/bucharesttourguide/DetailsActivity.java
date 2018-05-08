package udacityscholarship.rada.raul.bucharesttourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class DetailsActivity extends AppCompatActivity {

    // String key used to get the int value of the Tab in MainActivity
    // from the Intent to start DetailsActivity
    private final String TAB_POSITION_STRING = "tab position";

    // String key used to get the int value of the clicked item position
    // in the fragment launching DetailsActivity, from the related Intent
    private final String ITEM_POSITION_STRING = "item position";

    //position of the current tab in MainActivity
    private int tabPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Button button = (Button) findViewById(R.id.back_button);

        tabPosition = getIntent().getIntExtra(TAB_POSITION_STRING, 1);

        int position = getIntent().getIntExtra(ITEM_POSITION_STRING,0);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(DetailsActivity.this, MainActivity.class);
                startMain.putExtra(TAB_POSITION_STRING, tabPosition);
                startActivity(startMain);
            }
        });

//        switch (tabPosition)

    }
}
