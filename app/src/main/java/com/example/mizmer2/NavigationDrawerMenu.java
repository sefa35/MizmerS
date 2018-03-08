package com.example.mizmer2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class NavigationDrawerMenu extends AppCompatActivity implements MyListenerForFriend{

    private TextView mTextMessage;
    public static ArrayList arrayList = new ArrayList();
    public static int[] array = new int[9];

    HomeFragment homeFragment;


    int answer1=0, answer2=0, answer3=0, answer4=0, answer5=0, answer6=0, answer7=0, answer8=0, answer9=0;
    private static int i = 0;

    private String nameStr,emailStr,usernameStr,pass1Str;
    private int type;
    private DatabaseReference databaseReference;


    BottomNavigationView navigation;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                 case R.id.navigation_menu:
                    //mTextMessage.setText(R.string.title_menu);

                    //navigation.setVisibility(View.INVISIBLE);

                   homeFragment = new HomeFragment();
                   getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, homeFragment, homeFragment.getTag()).commit();

                    return true;
                case R.id.navigation_dtmm:
                    //mTextMessage.setText(R.string.title_dtmm);

                    //homeFragment.onHiddenChanged(true);

                    DtmmFragment dtmmFragment = new DtmmFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, dtmmFragment, dtmmFragment.getTag()).commit();


                    return true;
//                case R.id.navigation_profile:
//                    //mTextMessage.setText(R.string.title_profile);
//
//                    return true;
                case R.id.navigation_suggestions:   // Arkadaş
                    //mTextMessage.setText(R.string.title_suggestions);
//                    LineupFragment lineupFragment = new LineupFragment();
//                getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, lineupFragment, lineupFragment.getTag()).commit();

                    SavedTabsFragment savedTabsFragment = new SavedTabsFragment();
                getFragmentManager().beginTransaction().replace(R.id.contentLayout, savedTabsFragment, savedTabsFragment.getTag()).commit();

                    return true;
                case R.id.navigation_aboutUs:
                    //mTextMessage.setText(R.string.title_aboutUs);
                    BizKimiz bizKimiz = new BizKimiz();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout,bizKimiz,bizKimiz.getTag()).commit();
                    return true;
            }
            return false;
        }
    };
    //Dtmm9Fragment dtmm9Fragment;
    // Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_menu);

        mTextMessage = (TextView) findViewById(R.id.message);
         navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //navigation.setSelectedItemId(R.id.Bottombaritemone);

        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, homeFragment, homeFragment.getTag()).commit();

        databaseReference = FirebaseDatabase.getInstance().getReference();

    }



    @Override
    public void sendValToListForFriend(int val) {

        final Bundle bundle1 = new Bundle();
        bundle1.putInt("forWhom",2);

//        array[i] = val;
//        i++;
//
//        textTest.setText(String.valueOf(array[i]));

        arrayList.add(val);
        //if (!String.valueOf(arrayList.size()).equals(null))
            //textTest.setText(String.valueOf(arrayList.get(i))); // TO SEE WHETHER WE CAN INSERT ELEMENTS TO ARRAYLIST OR NOT

        i++;


        if (i==9 && i <= 27) { // Testi 3 arkadaşı için yababilir !!
            //bundle = new Bundle();
            //dtmm9Fragment = new Dtmm9Fragment();

            answer1 = Integer.parseInt(String.valueOf(arrayList.get(0)));
            answer2 = Integer.parseInt(String.valueOf(arrayList.get(1)));
            answer3 = Integer.parseInt(String.valueOf(arrayList.get(2)));
            answer4 = Integer.parseInt(String.valueOf(arrayList.get(3)));
            answer5 = Integer.parseInt(String.valueOf(arrayList.get(4)));
            answer6 = Integer.parseInt(String.valueOf(arrayList.get(5)));
            answer7 = Integer.parseInt(String.valueOf(arrayList.get(6)));
            answer8 = Integer.parseInt(String.valueOf(arrayList.get(7)));
            answer9 = Integer.parseInt(String.valueOf(arrayList.get(8)));

//            bundle.putInt("answerOf1",  answer1);   //SEND ARRAY TO Dtmm9Fragment'S BTNCLICKED METHOD
//            bundle.putInt("answerOf2",  answer2);
//            bundle.putInt("answerOf3",  answer3);
//            bundle.putInt("answerOf4",  answer4);
//            bundle.putInt("answerOf5",  answer5);
//            bundle.putInt("answerOf6",  answer6);
//            bundle.putInt("answerOf7",  answer7);
//            bundle.putInt("answerOf8",  answer8);
//            bundle.putInt("answerOf9",  answer9);
//            dtmm9Fragment.setArguments(bundle);


            int[] answersArray = new int[]{answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9};
            int max = 0;
            for (int i = 0 ; i < 9 ; i++){
                if(answersArray[i] > max)  max = answersArray[i];
            }

            // find the INDEXes of hihest rates
            ArrayList<Integer> equality = new ArrayList<>();
            for(int i = 0; i < 9; i++){
                if (answersArray[i] == max || answersArray[i] == (max - 1)){
                    equality.add(i+1); //INDEX OF MAX
                }
            }

            //***************************************** EQUALITY RULES
            if (equality.size() == 1){

                resetSendingValInterface(); // To make this method DYNAMIC !!

                SonucFragment sonucFragment = new SonucFragment();
                bundle1.putInt("whichquestion",equality.get(0));

//                Bundle extras = getIntent().getExtras();
//                nameStr = extras.getString("name");
//                emailStr = extras.getString("email");
//                usernameStr = extras.getString("username");
//                pass1Str = extras.getString("password");
//
//                Toast.makeText(this,nameStr+"-"+emailStr+"-"+usernameStr+"-"+pass1Str,Toast.LENGTH_LONG).show();
//                Contact contact = new Contact(nameStr, emailStr, usernameStr, pass1Str, equality.get(0));
//                databaseReference.child(emailStr.replace('.',' ')).setValue(contact);



                sonucFragment.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, sonucFragment, sonucFragment.getTag()).commit();

                navigation.setVisibility(View.VISIBLE);

//                            goToSonuc.putExtra("whichquestion", (int) equality.get(0) );
//                            startActivity(goToSonuc);
            }
            else if(equality.size()==2) {

                resetSendingValInterface();

                Asama2Fragment asama2Fragment = new Asama2Fragment();
                bundle1.putInt("equality1", equality.get(0));
                bundle1.putInt("equality2", equality.get(1));
                bundle1.putInt("size", equality.size());
                asama2Fragment.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, asama2Fragment, asama2Fragment.getTag()).commit();

                navigation.setVisibility(View.VISIBLE);


//                            goToAsama2.putExtra("equality1",equality.get(0));
//                            goToAsama2.putExtra("equality2",equality.get(1));
//                            goToAsama2.putExtra("size",equality.size());
//                            startActivity(goToAsama2);
            }
            else if (equality.size()==3){

                resetSendingValInterface();

                Asama2Fragment asama2Fragment = new Asama2Fragment();
                bundle1.putInt("equality1", equality.get(0));
                bundle1.putInt("equality2", equality.get(1));
                bundle1.putInt("equality3", equality.get(2));
                bundle1.putInt("size", equality.size());
                asama2Fragment.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, asama2Fragment, asama2Fragment.getTag()).commit();

                navigation.setVisibility(View.VISIBLE);


//                            goToAsama2.putExtra("equality1",equality.get(0));
//                            goToAsama2.putExtra("equality2",equality.get(1));
//                            goToAsama2.putExtra("equality3",equality.get(2));
//                            goToAsama2.putExtra("size",equality.size());
//                            startActivity(goToAsama2);
            }
            else{  //IF THERE IS EQUALITY MORE THAN 3 TIMES TAKE THE HIGHEST RATE

                resetSendingValInterface();

                SonucFragment sonucFragment = new SonucFragment();
                bundle1.putInt("whichquestion",equality.get(0));
                sonucFragment.setArguments(bundle1);
                getSupportFragmentManager().beginTransaction().replace(R.id.contentLayout, sonucFragment, sonucFragment.getTag()).commit();

                navigation.setVisibility(View.VISIBLE);



//                            goToSonuc.putExtra("whichquestion", (int) equality.get(0) );
//                            startActivity(goToSonuc);
            }


        }


    }

    private void resetSendingValInterface() {
        i = 0; //To make this method DYNAMIC
        while (!arrayList.isEmpty()){
            int k = 0;
            arrayList.remove(k);
            k++;
        }
    }
}
