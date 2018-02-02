package com.example.mizmer2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dtmm1Fragment extends Fragment {

    Button button;
    TextView textView,seekBarValue;
    SeekBar seekBar;

    public static int counter = 1;


    public Dtmm1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_dtmm1, container, false);
        textView = (TextView) v.findViewById(R.id.text_dtmm1);
        seekBarValue = (TextView)v.findViewById(R.id.seekBarValue);
        button = (Button)v.findViewById(R.id.ilerleBtn1);
        seekBar = (SeekBar)v.findViewById(R.id.seekBar1);
        button.setOnClickListener(null);

            initSeekBar();

        if (counter == 1) textView.setText("1- Arkadaşım; çevresiyle uyumlu olmaya ve kurallara uymaya özen gösteren, görev ve sorumluluklarına dikkat eden, hesaplı ve kontrollü hareket etmeye çalışan, belirsizlikten çok rahatsız olan, titiz ve düzenli olmaya eğilimli biridir. Güven ve emniyete çok fazla önem verir. İnsanlara güven duyana kadar kendisiyle ilgili pek bir şey anlatmamayı tercih eder. Bir durum karşısında aklına olumlu-olumsuz tüm ihtimaller gelir. Kendini en kötü ihtimale göre hazırlayıp önlem almayı tercih eder. Her tür bilgiyi gelecekte lazım olabilir diye depolar. Karar verirken tüm ihtimalleri hesapladığından karar vermekte zorlanabilir. Yaşamında bilgili, kendinden emin, kararlı ve güvenebileceği birinden akıl almaya çok önem verir ve bu kişinin yönlendirmelerine uygun davranmaya çalışır.");



        return v;
    }

    private void setQuestions() {

        if (counter == 2)textView.setText("2- Arkadaşım; hırslı, rekabetçi ve yarışmacı biridir. Bulunduğu ortamlarda ön planda ve popüler olmaya çok önem verir. Başarılarıyla her zaman en önde olmak ister. Yenilmek ve başarısız olmaya tahammül edemez. Bu nedenle hedefleri doğrultusunda başarılı oluncaya kadar durmadan çalışabilir. Kendisinden büyüklere ya da arkadaşlarına nasıl davranması gerekiyorsa öyle davranır. Çevresindekiler üzerinde hayranlık ve beğeni uyandıracak bir imaj ve görünüme sahip olmayı çok önemser. Hedeflerine en kısa zamanda ulaşmak ve başarılı olmak için kural ve sınırlara takılmaz, pratik yollar bulur.");
        else if (counter == 3)textView.setText("3- Arkadaşım; sakin, sabırlı, uyumlu ve barışçıl biridir. Çevresindekilere karşı kabullenici, esnek ve biraz da utangaç bir yapıya sahiptir. Kavga ve tartışmalardan kaçınır. Uzlaşmacı ve arabulucu yapısı ile kavga ve tartışma ortamlarında arkadaşlarını sakinleştirir. Uyumak, yemek yemek, dinlenmek onun için çok önemlidir. Düzeninin ve rahatının bozulmamasına çok dikkat eder. Ani değişikliklere uyum sağlamakta zorlanabilir. Pek aceleci olmadığından hareket ve tepkilerinde diğer arkadaşlarından daha yavaştır. Genelde çok sakin ve uyumlu olmasına rağmen çok fazla üzerine gidildiğinde istemese de öfkeyle karşılık verebilir. İstemediği bir şeye zorlandığında, direkt itiraz etmez ancak yapmamak konusunda inat edebilir.");
        else if (counter == 4)textView.setText("4- Arkadaşım; genel olarak içe dönük (kendiyle baş başa kalmayı seven), çok duygusal, merhametli, tüm canlılara karşı duyarlı ve dost canlısı biridir. Duygusal açıdan hassas bir yapıya sahiptir. Kolay incinir ancak incindiğini genellikle belli etmez. İncindiğinin çevresindekiler tarafından fark edilmesini ve anlaşılmasını bekler. İçinden geldiği gibi, nasıl hissediyorsa öyle davranır. Zaman zaman çevresindekilerle birlikte vakit geçirmekten keyif alsa da genelde kendi duygu dünyasıyla baş başa kalıp romantik hayaller kurmaktan hoşlanır. Üzüntü-sevinç, coşku-hüzün, mutluluk-mutsuzluk gibi duygusal iniş-çıkışları sıklıkla yaşar. Duygularını tanımaya ve anlamaya çalışır. Duygu ve düşüncelerini resim, müzik, şiir gibi sanatsal yollarla ifade etmeyi tercih eder.");
        else if (counter == 5)textView.setText("5- Arkadaşım; her şart ve durumda öne çıkan, arkadaşlarına liderlik eden ve geride durmaktan hiç hoşlanmayan biridir. Çevresindekileri her şart ve durumda yönlendirmek ve yönetmek ister ancak yönetilmekten ve kendisine emredilmesinden aşırı derecede rahatsız olur. Onun için hayatta en önemli olan güçlü olmaktır. Zayıflıktan ve güçsüzlükten hiç hoşlanmaz. Zorluklar karşısında güçlü ve dayanıklı biridir. Mücadeleden asla vazgeçmez. Ağlayan, sızlanan kişilere çok değer vermez. Arkadaşlarına karşı cömert ve koruyucudur. Arkadaşlarının daima onun sözünü dinlemelerini ister. Onu kızdırırlarsa çok çabuk öfkelenir ve fazlasıyla karşılık verir. Kavga etmekten hiç çekinmez.");
        else if (counter == 6)textView.setText("6- Arkadaşım; genel olarak ciddi, uslu, temiz, tertipli ve düzenli olmaya çok fazla önem veren biridir. Her zaman “örnek” bir öğrenci olmaya ve her şeyi yapılması gerektiği gibi yapmaya çalışır. Her şeyin doğrusunu ve nasıl yapılması gerektiğini öğrenir ve o şekilde yapar. Arkadaşlarını da ne yapmaları ve ne yapmamaları gerektiği konusunda uyarır. Görgü, ahlak ve sınıf kurallarına uymaya çok önem verir. Kurallara aykırı davrandığında bundan çok rahatsız olur kendini suçlar. Her şeyin planlı ve programlı olması gerektiğini düşünür. Plansız hareket etmekten hiç hoşlanmaz. Bir şey hatalı, eksik ve yanlış olduğunda çok rahatsız olur, çabucak düzeltmeye çalışır. Haksızlıklara çok duyarlıdır, kendisine ya da başka birine haksızlık yapıldığında çabuk kızar. Bir başkasına haksızlık yaptığında da kendini çok fazla suçlar.");
        else if (counter == 7)textView.setText("7- Arkadaşım; çok hareketli, konuşkan, dışa dönük, girişken, neşeli, şakacı, esprili, heyecan ve maceradan hoşlanan biridir. Enerjik yapısı ve şakalarıyla bulunduğu ortamda hemen fark edilir. Herkesle hemen ilişki kurar, kendisini sevdirir. Hızlı düşünüp hızlı hareket eder. Her şeyi kurcalamayı seven, meraklı biridir. Sürekli yeni bir şeyler yapmak ister. Hayal gücü çok geniştir. Kafasında hep yeni fikir ve projeler vardır. Maceralardan ve keşfetmekten çok keyif alır. Zora ve sıkıntıya hiç gelemez. Konuşmayı çok sever ancak dinlemekten çok çabuk sıkılır. Sorunlara aklını takmaz. Bir şeye uzun süre odaklanmakta zorlanır. Dikkati çok kolay dağılabilir. Aynı şeyleri yapmaktan çok çabuk sıkılır.");
        else if (counter == 8)textView.setText("8- Arkadaşım; yalnız başına olmaktan hoşlanan, sessiz, az konuşan, çekingen, çevresindekilere karşı biraz soğuk ve mesafeli biridir. Kalabalık ve gürültüden hoşlanmaz. Herhangi bir ortamda insanların ona bakması ve onunla ilgilenmesinden oldukça rahatsız olur. Dikkat çekmekten ve göz önünde olmaktan özellikle kaçınır. Duygusal davranışlardan ve sarılmaktan hoşlanmaz. Bilmeye ve öğrenmeye çok merak duyar. Zamanımın çoğunu tek başına okuyarak ve düşünerek geçirir. Çevresinde olan olayları sessizce gözlemler ve anlamaya çalışır. Dikkatini ilgilendiği konuya vererek saatlerce çalışabilir.");
        else if (counter == 9)textView.setText("9- Arkadaşım; dışa dönük, çevresindekilere karşı sıcak ve ilgili, insanlarla çabuk kaynaşabilen, arkadaş canlısı, merhametli, yardımsever, çok duygusal ve çabuk hislenen biridir. Sevilmek, ilgilenilmek, beğenilmek ve fark edilmek onun için çok önemlidir. Çevresinden daima ilgi ve sevgi bekler. İlgi ve sevgi görmediği zaman çabuk kırılıp alınabilir. Arkadaşlarına yardım etmekten ve onlarla her şeyini paylaşmaktan çok hoşlanır. Arkadaşlarını kırmaktan kaçındığı için onlara hayır demekte çok zorlanır. Onların da kendisine hayır demesine çabucak alınır. Ancak küskünlüğü uzatmak istemez, gözü hep barışmadadır. Gururu incinmedikçe ilişkilerini koparamaz.");
    }

    private void initSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int value, boolean fromUser) {
                //textView.setText("Normal SeekBar- Value: " + value);
                //seekBarValue.setText(value);
                final int val = value;




                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                           // if (counter < 9) {


                            MyListener myListener = (MyListener) getActivity();
                                myListener.sendValToList(val);


                                counter++;
                                //textView.setText("reset");

                            setQuestions();  //changing the questions up to the 9
                                seekBar.setProgress(0);

                                //Dtmm2Fragment dtmm2Fragment = new Dtmm2Fragment();
                                //getFragmentManager().beginTransaction().replace(R.id.contentExamLayout, dtmm2Fragment, dtmm2Fragment.getTag()).commit();

//                            }
//                            else {
//                                Dtmm2Fragment dtmm2Fragment = new Dtmm2Fragment();
//                                getFragmentManager().beginTransaction().replace(R.id.contentExamLayout, dtmm2Fragment, dtmm2Fragment.getTag()).commit();
//
//                            }
                        }
                    });



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



}
