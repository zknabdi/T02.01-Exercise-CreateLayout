/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.datafrominternet;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.datafrominternet.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // COMPLETED (26) Create an EditText variable called mSearchBoxEditText
    EditText mSearchBoxEditText;
    // COMPLETED (27) Create a TextView variable called mUrlDisplayTextView
    TextView mUrlDisplayTextView;
    // COMPLETED (28) Create a TextView variable called mSearchResultsTextView
    TextView mSearchResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // COMPLETED (29) Use findViewById to get a reference to mSearchBoxEditText
        mSearchBoxEditText = (EditText)findViewById(R.id.et_search_box);
        // COMPLETED (30) Use findViewById to get a reference to mUrlDisplayTextView
        mUrlDisplayTextView =(TextView)findViewById(R.id.tv_url_display);
        // COMPLETED (31) Use findViewById to get a reference to mSearchResultsTextView
        mSearchResultsTextView = (TextView)findViewById(R.id.tv_github_search_results_json);
    }

    // Do 2 - 7 in main.xml ///////////////////////////////////////////////////////////////////////
    // COMPLETED (2) Create a menu xml called 'main.xml' in the res->menu folder
    // COMPLETED (3) Add one menu item to your menu
    // COMPLETED (4) Give the menu item an id of @+id/action_search
    // COMPLETED (5) Set the orderInCategory to 1
    // COMPLETED (6) Show this item if there is room (use app:showAsAction, not android:showAsAction)
    // COMPLETED (7) Set the title to the search string ("Search") from strings.xml
    // Do 2 - 7 in main.xml ///////////////////////////////////////////////////////////////////////


    // COMPLETED (8) Override onCreateOptionsMenu
    // COMPLETED (9) Within onCreateOptionsMenu, use getMenuInflater().inflate to inflate the menu
    // COMPLETED (10) Return true to display your menu

    // COMPLETED (2) Create a method called makeGithubSearchQuery
    // COMPLETED (3) Within this method, build the URL with the text from the EditText and set the built URL to the TextView
    void makeGithubSearchQuery (){
        String githubQuery = mSearchBoxEditText.getText().toString();
        URL githubSearchUrl = NetworkUtils.buildUrl(githubQuery);
        mUrlDisplayTextView.setText(githubSearchUrl.toString());
        // COMPLETED (2) Call getResponseFromHttpUrl and display the results in mSearchResultsTextView
        // COMPLETED (3) Surround the call to getResponseFromHttpUrl with a try / catch block to catch an IOException
        String githubSearchResults = null;
        try{
            githubSearchResults = NetworkUtils.getResponseFromHttpUrl(githubSearchUrl);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
     @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
     }

    // COMPLETED (11) Override onOptionsItemSelected
    // COMPLETED (12) Within onOptionsItemSelected, get the ID of the item that was selected
    // COMPLETED (13) If the item's ID is R.id.action_search, show a Toast and return true to tell Android that you've handled this menu click
    // COMPLETED (14) Don't forgot to call .show() on your Toast
    // COMPLETED (15) If you do NOT handle the menu click, return super.onOptionsItemSelected to let Android handle the menu click

    @Override

    public boolean onOptionsItemSelected(MenuItem item){
        int menuItemThatWasSelected = item.getItemId();
        if(menuItemThatWasSelected == R.id.action_search){
            // COMPLETED (4) Remove the Toast message when the search menu item is clicked
            // COMPLETED (5) Call makeGithubSearchQuery when the search menu item is clicked
            makeGithubSearchQuery();
//            Context context =MainActivity.this;
//            String message = "Search click";
//            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            return true;


        }
        return super.onOptionsItemSelected(item);

    }
}
