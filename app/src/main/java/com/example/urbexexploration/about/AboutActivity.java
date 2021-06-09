package com.example.urbexexploration.about;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.urbexexploration.R;
import com.example.urbexexploration.databinding.ActivityAboutBinding;

/**
 * Klasa głównego widoku "About" , zawierającego ogólne informacje na temat urbex.
 */
public class AboutActivity extends AppCompatActivity {
    private ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.aboutTitleTextView.setText("Trochę o URBEX");
        binding.aboutTitle2TextView.setText("Urbex (z ang. urban exploration — eksploracja miejska) — forma aktywności polegająca na eksplorowaniu opuszczonych, zrujnowanych, zapomnianych, niedostępnych czy ukrytych budynków i instalacji stworzonych przez człowieka. Celem osób uprawiających urbex jest filmowanie, fotografowanie lub po prostu zdobywanie informacji dotyczących danego miejsca. Wszystko odbywa się bez ingerencji w jego stan, zgodnie z zasadą take only pictures, leave only footsteps (zabierz tylko zdjęcia, zostaw tylko ślady stóp).");
        binding.aboutDlaKogoTextView.setText("Dla kogo to ?");
        binding.aboutDlaKogo2TextView.setText("Trudno jednoznacznie zdefiniować typowego urbexowicza. Motywacje do rozpoczęcia przygody z tą formą spędzania czasu są różne. Osoby pasjonujące się fotografią mogą odnaleźć w opuszczonych miejscach niepowtarzalny klimat i okazje do zrobienia porywających zdjęć. Podobnie rzecz ma się z filmowcami, który dodatkowo często tworzą wideorelacje z takich wypadów i zamieszczają np. na YouTube. Kolejna grupa to miłośnicy adrenaliny, którzy spełniają się, wchodząc tam, gdzie niewielu było, niejednokrotnie stosując przy tym techniki parkourowe. Wśród eksploratorów nie brakuje też amatorów historii, legend miejskich, teorii spiskowych, zjawisk paranormalnych itd. Przekrój jest bardzo duży. Rzecz jasna, jak w każdej społeczności, trafiają się czarne owce, czyli osobnicy odwiedzający opuszczone miejsca w celu dokonywania aktów wandalizmu, kradzieży mienia czy spożywania używek. W takich przypadkach nie mamy jednak do czynienia z urbexem, co na każdym kroku podkreślają osoby w niego zaangażowane.");
        binding.aboutJakZaczacTextView.setText("Jak zacząć ?");
        binding.aboutJakZaczac2TextView.setText("Chodzenie po opuszczonych budynkach może nie wydawać się czymś trudnym czy wymagającym, ale realia często okazują się zupełnie inne. Z tego powodu należy przede wszystkim określić granicę swoich możliwości — tak fizycznych, jak i psychicznych — i na tej podstawie wybierać cele swoich eksploracji. Zagrożenia występujące w niejednokrotnie zdewastowanych miejscach potrafią zaskoczyć nawet doświadczonych poszukiwaczu przygód, a co dopiero początkujących.  Nie mając pojęcia o wspinaczce nie wybieramy obiektów wymagających tej umiejętności. Osoby słusznej budowy powinny unikać ciasnych przejść, grot czy osłabionych stropów itd. Mając lęk wysokości, unikamy wysoko położonych podestów, dachów czy grani. Wszelkie fobie dotyczące pająków, szczurów czy robactwa też mogą być przyczyną ataków paniki podczas eksplorowania opuszczonych stref. Mając problemy z sercem, raczej nie angażujemy się w wyprawy do miejsc, wokół których krążą niepokojące legendy, etc. Kolejna sprawa to drużyna. Urbex w pojedynkę to raczej kiepski pomysł dla nowicjuszy. We dwójkę czy więcej osób mamy większe możliwości odkrycia wszystkich sekretów, a przy okazji wsparcie innych daje komfort psychiczny, gdy atmosfera jest „gęsta”. To również większe szanse ratunku w razie wypadku. Jeśli jednak nie mamy z kim wędrować, przed wyruszeniem informujemy kogoś zaufanego o naszych planach z uwzględnieniem wybranej lokalizacji oraz terminów wyprawy i powrotu.  Ponadto przed rozpoczęciem eksploracji warto zapoznać się z materiałami urbexowych weteranów na forach, blogach czy YouTube. Mając takie podstawy, można rozpocząć kompletowanie sprzętu.");
        binding.aboutPrawoTextView.setText("URBEX, a prawo");
        binding.aboutPrawo2TextView.setText("Trzeba mieć świadomość, że urbex to niejednokrotnie działanie na granicy prawa. Czasem wchodząc na dany obiekt nie mamy nawet świadomości, że jest to niedozwolone. Naruszenie terenu prywatnego bez pozwolenia może skutkować usunięciem przez ochronę lub konsekwencjami finansowymi, a nawet prawnymi. Pamiętamy, że w razie spotkania z ochroną najlepiej przedstawić cel swojej wizyty — istnieje spora szansa, że uzyskamy pozwolenie na zwiedzanie. Jednak w dobrym tonie jest zachowanie tej informacji dla siebie, gdyż przychylność pracownika ochrony może go kosztować utratę pracy w razie ujawnienia tego faktu publicznie. Można też podjąć próbę kontaktu z właścicielem w celu uzyskania zgody. Jeśli się nie uda — najlepiej odpuścić. Ostatnia kwestia: urbex to hobby uprawiane na własną odpowiedzialność.");
        binding.aboutButtonLinks.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            goToLinksAboutActivity(v);
            }
        });
    }

    /**
     * Przejście do widoku, zawieraącego odnośniki do stron internetowych powiązanych z tematyką urbex.
     */
    public void goToLinksAboutActivity(View view) {
        Intent intent = new Intent(this, LinksAboutActivity.class);
        startActivity(intent);
    }


}