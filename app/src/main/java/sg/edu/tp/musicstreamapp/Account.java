package sg.edu.tp.musicstreamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Account extends AppCompatActivity {
    private Button btnClearSearchHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        getSupportActionBar().setTitle("Account");

        btnClearSearchHistory =(Button) findViewById(R.id.btnClearSearchHistory);
        btnClearSearchHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }
    public void openDialog(){
        ClearHistory clearHistory = new ClearHistory();
        clearHistory.show(getSupportFragmentManager(),"clear history");

    }

    public void changePassword(View view) {
        startActivity(new Intent(Account.this, ChangePassword.class));}

    public void logOut(View view) {
        startActivity(new Intent(Account.this, MainActivity.class));} public void Discover(View view){
        startActivity(new Intent(Account.this, Discover.class));
    }
    public void Library(View view){
        startActivity(new Intent(Account.this, Library.class));
    }
    public void Settings(View view){
        startActivity(new Intent(Account.this, Settings.class));
    }
}
