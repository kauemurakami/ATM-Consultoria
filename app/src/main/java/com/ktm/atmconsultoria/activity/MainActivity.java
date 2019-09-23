package com.ktm.atmconsultoria.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.ktm.atmconsultoria.R;
import com.ktm.atmconsultoria.fragments.ClientesFragment;
import com.ktm.atmconsultoria.fragments.PrincipalFragment;
import com.ktm.atmconsultoria.fragments.ServicosFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
                enviarEmail();
            }
        });

        //fragmenttela princiapl
        PrincipalFragment principalFragment = new PrincipalFragment();
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame, principalFragment);
        transaction.commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_principal) {
            // Handle the camera action
            PrincipalFragment principalFragment = new PrincipalFragment();
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, principalFragment);
            transaction.commit();

        } else if (id == R.id.nav_clientes) {

            ClientesFragment clienteFragment = new ClientesFragment();
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, clienteFragment);
            transaction.commit();

        } else if (id == R.id.nav_servicos) {

            ServicosFragment servicosFragment = new ServicosFragment();
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, servicosFragment);
            transaction.commit();

        } else if (id == R.id.nav_contato) {
            enviarEmail();
        } else if (id == R.id.nav_sobre) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void enviarEmail(){

        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{
                "atmconsultoria@gmail.com" , "atm@gmail.com"
        });
        i.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo app");
        i.putExtra(Intent.EXTRA_TEXT, "mensagem automática");

        //configurando app proprios para email
        i.setType("message/rfc822");
        //        i.setType("application/pdf");
        //        i.setType("image/png");

        startActivity(i.createChooser(i, "escolha o app para envial o email"));
    }
}
