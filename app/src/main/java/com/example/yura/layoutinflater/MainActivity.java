package com.example.yura.layoutinflater;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private static final List<Cat> cats = new ArrayList<Cat>();

    private static boolean flag=false;

    static {
        cats.add(new Cat("Васька", "котэ"));
        cats.add(new Cat("Мурзик", "котяра"));
        cats.add(new Cat("Мурка", "кошка"));
        cats.add(new Cat("Барсик", "котик"));
        cats.add(new Cat("Лиза", "кошечка"));
        cats.add(new Cat("Рыжик", "кошак"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<Cat> adapter = new CatAdapter(this);

        // добавляем нового кота в список
/*
        Cat ginger = new Cat("Рыжик", "кошак");
        adapter.add(ginger);
        adapter.notifyDataSetChanged();
*/
        setListAdapter(adapter);

    }

    public void onClick(View view) {
        if (!flag) {flag=true;} else {flag=false;}
        onCreate(Bundle.EMPTY);
    }

    private static class Cat {
        public final String name;
        public final String gender;

        public Cat(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    private class CatAdapter extends ArrayAdapter<Cat> {

        public CatAdapter(Context context) {
            super(context,R.layout.list_item, cats);
//            super(context, android.R.layout.simple_list_item_2, cats);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Cat cat = getItem(position);

            if (convertView == null) {


/*
                        convertView = LayoutInflater.from(getContext())
                        .inflate(android.R.layout.simple_list_item_2,
                                parent, false);
*/

if (flag)         {      convertView = LayoutInflater.from(getContext())
                        .inflate(R.layout.list_item, parent, false);}
                        else
{convertView = LayoutInflater.from(getContext())
        .inflate(R.layout.list_item, null);}


            }
            ((TextView) convertView.findViewById(R.id.text1))
                    .setText(cat.name);
            ((TextView) convertView.findViewById(R.id.text2))
                    .setText(cat.gender);


            return convertView;
        }
    }

}



