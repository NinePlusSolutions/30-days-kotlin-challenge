package com.example.customnavigatordrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.customnavigatordrawer.book.Book;
import com.example.customnavigatordrawer.fragment.FavoriteFragment;
import com.example.customnavigatordrawer.fragment.HistoryFragment;
import com.example.customnavigatordrawer.fragment.HomeFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import category.Category;
import category.CategoryAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final int FRAGMENT_HOME=0;
    private static final int FRAGMENT_FAVORITE=1;
    private static final int FRAGMENT_HISTORY=2;
    private int mCurrentFragment=FRAGMENT_HOME;

    private DrawerLayout mDrawerLayout;
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //rcv
//        rcvCategory=findViewById(R.id.rcv_category);
//        categoryAdapter=new CategoryAdapter(this);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
//        rcvCategory.setLayoutManager(linearLayoutManager);
//        categoryAdapter.setData(getListCategory());
//        rcvCategory.setAdapter(categoryAdapter);
//        //rcv


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mDrawerLayout=findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,mDrawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

    }

//    //rcv
//    private List<Category> getListCategory(){
//        List<Category>listCategory=new ArrayList<>();
//        List<Book>listBook=new ArrayList<>();
//        listBook.add(new Book(R.drawable.anh1,"book1"));
//        listBook.add(new Book(R.drawable.anh2,"book2"));
//        listBook.add(new Book(R.drawable.anh3,"book3"));
//        listBook.add(new Book(R.drawable.anh4,"book4"));
//        listBook.add(new Book(R.drawable.anh5,"book5"));
//
//        listBook.add(new Book(R.drawable.anh1,"book1"));
//        listBook.add(new Book(R.drawable.anh2,"book2"));
//        listBook.add(new Book(R.drawable.anh3,"book3"));
//        listBook.add(new Book(R.drawable.anh4,"book4"));
//        listBook.add(new Book(R.drawable.anh5,"book5"));
//
//
//        listCategory.add(new Category("Category1",listBook));
//        listCategory.add(new Category("Category2",listBook));
//        listCategory.add(new Category("Category3",listBook));
//        listCategory.add(new Category("Category4",listBook));
//        listCategory.add(new Category("Category5",listBook));
//
//
//        return listCategory;
//    }
    //rcv

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.nav_home){
            if (mCurrentFragment!=FRAGMENT_HOME){
                replaceFragment(new HomeFragment());
                mCurrentFragment=FRAGMENT_HOME;
            }
        }else if(id==R.id.nav_favorite){

            if (mCurrentFragment!=FRAGMENT_FAVORITE){
                replaceFragment(new FavoriteFragment());
                mCurrentFragment=FRAGMENT_FAVORITE;
            }

        }else if (id==R.id.nav_history){
            if (mCurrentFragment!=FRAGMENT_HISTORY){
                replaceFragment(new HistoryFragment());
                mCurrentFragment=FRAGMENT_HISTORY;
            }

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame,fragment);
        transaction.commit();
    }
}