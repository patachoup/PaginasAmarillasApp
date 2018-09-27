package com.joseluis0218.pginasamarillasapp.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.joseluis0218.pginasamarillasapp.R;
import com.joseluis0218.pginasamarillasapp.adapters.LugarAdapter;
import com.joseluis0218.pginasamarillasapp.models.Lugar;
import com.joseluis0218.pginasamarillasapp.repositories.LugarRepositorie;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.joseluis0218.pginasamarillasapp.repositories.LugarRepositorie.places;

public class SearchResultActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    LugarAdapter adapter;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        recyclerView = (RecyclerView) findViewById(R.id.empresas_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LugarAdapter(places, SearchResultActivity.this);
        adapter.setPlaces(LugarRepositorie.getPlaces());
        recyclerView.setAdapter(adapter);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_search,menu);
        final MenuItem actionItem = menu.findItem(R.id.search);
        searchView = (SearchView) actionItem.getActionView();
        searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(!searchView.isIconified()){
                    searchView.setIconified(true);
                }
                actionItem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Lugar> filtermodelist = filter(places,newText);
                adapter.setfilter(filtermodelist);
                return true;
            }
        });
        return true;

    }
    private List<Lugar> filter(List<Lugar> p1,String query){
        query = query.toLowerCase();
        final List<Lugar> filteredModeList = new ArrayList<>();
        for (Lugar model:p1){
            final String text = model.getNombre().toLowerCase();
            final String text2 = model.getCategoria().toLowerCase();
            if (text.startsWith(query)|| text2.startsWith(query)){
                filteredModeList.add(model);
            }
        }
        return filteredModeList;
    }

}
