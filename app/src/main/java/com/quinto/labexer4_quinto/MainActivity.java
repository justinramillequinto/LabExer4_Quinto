package com.quinto.labexer4_quinto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] names, countries, industries, ceo, descriptions;
    int[] logo = {R.drawable.icbc, R.drawable.jpmorganchase, R.drawable.chinaconstructionbank, R.drawable.agriculturalbankofchina,
            R.drawable.bankofamerica, R.drawable.apple, R.drawable.pinganinsurancegroup, R.drawable.bankofchina, R.drawable.royaldutchshell,
            R.drawable.wellsfargo, R.drawable.exxonmobil, R.drawable.att, R.drawable.samsungelectronics, R.drawable.citigroup};
    ArrayList<Company> companies = new ArrayList<Company>();
    ListView lvCompanies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getResources().getStringArray(R.array.company);
        countries = getResources().getStringArray(R.array.country);
        industries = getResources().getStringArray(R.array.industry);
        ceo = getResources().getStringArray(R.array.ceo);
        descriptions = getResources().getStringArray(R.array.description);

        for (int i = 0; i < names.length; i++) {
            companies.add(new Company(logo[i], names[i], countries[i], industries[i], ceo[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.item, companies);
        lvCompanies = findViewById(R.id.lvAndroid);
        lvCompanies.setAdapter(adapter);
        lvCompanies.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logo[position]);
        dialog.setTitle(names[position]);
        dialog.setMessage(descriptions[position]);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();
    }
}
