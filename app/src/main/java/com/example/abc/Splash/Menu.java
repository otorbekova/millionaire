package com.example.abc.Splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.Dialog.Dialog_01;
import com.example.abc.Dialog.Dialog_02;
import com.example.abc.Dialog.Dialog_03;
import com.example.abc.Dialog.Dialog_04;
import com.example.abc.MainActivity;
import com.example.abc.R;
import com.example.abc.Result.Res_sms;
import com.example.abc.Result.Win_Result;
import com.example.abc.Value.MMV;
import com.example.abc.Value.QuestionClass;

import java.util.Collections;
import java.util.Random;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {
    private static final int Res = 1;
    private TextView tvQueConter, ball, tvQue;
    private MMV mViewModel;
    private int sum, caunt;
    private Button btOpt1, btOpt2, btOpt3, btOpt4, half, friend;
    private Random random = new Random();
    private static final String DIALOG_DATE = "DialogDate";
    //list for que
    ArrayList<QuestionClass> queList = new ArrayList<>();

    int conter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init(); //функция Для инициализации  вюшек

        int m = random.nextInt(4); //рандом для вывода вопросов
        if (m == 1) {
            QuestionAdd();
        } else if (m == 2) {
            QuestionAdd2();
        } else if (m == 3) {
            QuestionAdd3();
        }

        mViewModel = ViewModelProviders.of(this).get(MMV.class); // инициализации ViewModel
        mViewModel.mResult.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer s) {
                ball.setText(String.valueOf(s));
                sum = s;
            }
        });

        conter = 0;
        loadQuetions(conter);
        friend.setOnClickListener(new View.OnClickListener() { // нажатие на кнопку звонок к другу
            @Override
            public void onClick(View view) {
                int i = random.nextInt(5);
                if (i == 1) {
                    Dialog_01 d;
                    Dialog_01 dialog_01 = new Dialog_01();
                    dialog_01.show(getSupportFragmentManager(), "cus");
                } else if (i == 2) {
                    Dialog_02 dialog_02 = new Dialog_02();
                    dialog_02.show(getSupportFragmentManager(), "cus02");
                } else if (i == 3) {
                    Dialog_03 dialog_03 = new Dialog_03();
                    dialog_03.show(getSupportFragmentManager(), "cus03");
                } else if (i == 4) {
                    Dialog_04 dialog_04 = new Dialog_04();
                    dialog_04.show(getSupportFragmentManager(), "cus04");
                }
                friend.setEnabled(false);
            }
        });
    }

    private void init() {
        tvQue = findViewById(R.id.tvQue);
        tvQueConter = findViewById(R.id.tvQueConter);
        ball = findViewById(R.id.Ball);
        half = findViewById(R.id.half);
        btOpt1 = findViewById(R.id.btOpt1);
        btOpt2 = findViewById(R.id.btOpt2);
        btOpt3 = findViewById(R.id.btOpt3);
        btOpt4 = findViewById(R.id.btOpt4);
        friend = findViewById(R.id.friend);
    }

    private void QuestionAdd() {
        queList.add(new QuestionClass("Какого цвета зеркало?", "A. Белого", "B. Зеленого",
                "C. Серебряного", "D. Никакого", "D. Никакого"));
        queList.add(new QuestionClass("На каком инструменте, как считается, играл древнерусский певец и сказатель Боян? ", "A. На баяне", "B. На гитаре",
                "C. На гуслях", "D. На виолончели", "C. На гуслях"));
        queList.add(new QuestionClass("В каком из этих стран один из официальных языков-французский", "A. Кения", "B. Республика Гаити",
                "C. Эквадор", "D. Венесуэла", "B. Республика Гаити"));
        queList.add(new QuestionClass("В каком из этих фильмов не снимался Александр Абдулов?", "A. Карнавал", "B. Чародеи",
                "C. Убить дракона", "D. Московские каникулы", "D. Московские каникулы"));
        queList.add(new QuestionClass("В каком году произошла Куликовская битва?", "A. 1380", "B. 1569",
                "C. 1661", "D. 1773", "A. 1380"));
        queList.add(new QuestionClass("Столица  Турции?", "A. Стамбул", "B. Бишкек",
                "C. Анкара", "D. Измир", "C. Анкара"));
        queList.add(new QuestionClass("Кто автор музыки к детской песенке Чунга-Чанга?", "A. Шаинский", "B. Зацепин",
                "C. Дербенев", "D. Шпиц", "A. Шаинский"));
        queList.add(new QuestionClass("Как называется самая глубокая точка поверхности Земли, находящаяся на дне Марианской впадены?", "A. Филлиппинская плита", "B. Бездна Челленджера",
                "C. Кермадек", "D. Черное Логово", "B. Бездна Челленджера"));
        queList.add(new QuestionClass("Белый медвежонок,который ищет друга ...", "A. Чупакабра", "B. Чунга-Чанга",
                "C. Чебурашка", "D. Умка", "D. Умка"));
        queList.add(new QuestionClass("О чем просят пассажиров самолета перед взлетом?", "A. Пристегнуть ремни", "B. Заплатить налоги",
                "C. Спать спокойно", "D. Сидеть тихо", "A. Пристегнуть ремни"));
        queList.add(new QuestionClass("В каком городе находится Красная площадь?", "A. Мадрид", "B. Рим",
                "C. Москва", "D. Париж", "C. Москва"));
        queList.add(new QuestionClass("Самая последняя нота?", "A. До", "B. Ля",
                "C. Фа", "D. Си", "D. Си"));
    } //вопросы

    private void QuestionAdd2() {
        queList.add(new QuestionClass("Что тут не является видом спорта?", "ТИРКЕК", "ФОЛЬГ",
                "C. НАРИСУМАБ", "D.МИНТОНДАБ", "C. НАРИСУМАБ"));
        queList.add(new QuestionClass("Какой музыкальный инструмент Ф. Лист называл «королем музыкальных инструментов»?", "A. Рояль", "B. Контрабас",
                "C. Скрипка", "D. Гитара", "A. Рояль"));
        queList.add(new QuestionClass("Какое слово лишнее:", "A. СОНАТА", "B. ПЕРСОНА",
                "C. ХРОНОМЕТРАЖ", "D. ФОНАРЬ", "C. ХРОНОМЕТРАЖ"));
        queList.add(new QuestionClass(" Как дедуктивная теория логика сформировалась в ... веке до н.э.", "A. II", "B. IV",
                "C. IX", "D. VII", "B. IV"));
        queList.add(new QuestionClass("Предметом логики являются формы и приемы ... познания.", "A. интуитивного", "B. эмоционального",
                "C. чувственного", "D. pационального", "C. pационального"));
        queList.add(new QuestionClass("Мысль, в которой утверждается или отрицается наличие в действительности какого-либо положения дел, - это", "A. суждение", "B. понятие",
                "C. гипотеза", "D. умозаключение", "A. суждение"));
        queList.add(new QuestionClass("Экстенсионал знака - это то же самое, что его", "A. контекст", "B. значение",
                "C. смысл", "D. интерпретатор", "B. значение"));
        queList.add(new QuestionClass("Логика - это ... наука.", "A. дескриптивная", "B. эмпирическая",
                "C. нормативная", "D. индуктивная", "C. нормативная"));
        queList.add(new QuestionClass("you any time to help me? - Sony, I", "A. Have you got, am not;", "B. Do you have, have got;",
                "C. Do you have;", "D. Do you have, don't;", "D. Do you have, don't;"));
        queList.add(new QuestionClass("Основной рабочий метод Ф. Бэкона - это:", "A. Анализ", "B. Синтез",
                "C. Дедукция", "D. Индукция", "D. Индукция"));
        queList.add(new QuestionClass(". При помощи объекта конфигурации «Константа» обеспечивается хранение:", "A. Единичной величины или набора значений, показывающего изменение этой величины во времени",
                "B. Чисел и строк",
                "C. Набора однотипных величин", "D. Единичной величины", "D. Единичной величины"));
        queList.add(new QuestionClass("О чем просят пассажиров самолета перед взлетом?", "A. Пристегнуть ремни", "B. Заплатить налоги",
                "C. Спать спокойно", "D. Сидеть тихо", "A. Пристегнуть ремни"));
    }

    private void QuestionAdd3() {
        queList.add(new QuestionClass(". При помощи объекта конфигурации «Константа» обеспечивается хранение:",
                "A. Единичной величины или набора значений, показывающего изменение этой величины во времени",
                "B. Чисел и строк",
                "C. Набора однотипных величин", "D. Единичной величины",
                "D. Единичной величины"));
        queList.add(new QuestionClass("Кто автор музыки к детской песенке Чунга-Чанга?", "A. Шаинский", "B. Зацепин",
                "C. Дербенев", "D. Шпиц", "A. Шаинский"));
        queList.add(new QuestionClass("Логика - это ... наука.", "A. дескриптивная", "B. эмпирическая",
                "C. нормативная", "D. индуктивная", "C. нормативная"));
        queList.add(new QuestionClass("Самая последняя нота?", "A. До", "B. Ля",
                "C. Фа", "D. Си", "D. Си"));
        queList.add(new QuestionClass("Что тут не является видом спорта?", "ТИРКЕК", "ФОЛЬГ",
                "C. НАРИСУМАБ", "D.МИНТОНДАБ", "C. НАРИСУМАБ"));
        queList.add(new QuestionClass("Какого цвета зеркало?", "A. Белого", "B. Зеленого",
                "C. Серебряного", "D. Никакого", "D. Никакого"));
        queList.add(new QuestionClass("you any time to help me? - Sony, I", "A. Have you got, am not;", "B. Do you have, have got;",
                "C. Do you have;", "D. Do you have, don't;", "D. Do you have, don't;"));
    }

    private void visible_btn() { // при нажатии на кнопку 50/50 Исчезала 2 кноки
        btOpt1.setVisibility(View.VISIBLE);
        btOpt2.setVisibility(View.VISIBLE);
        btOpt3.setVisibility(View.VISIBLE);
        btOpt4.setVisibility(View.VISIBLE);

    }


    public void loadQuetions(int n) {
        final QuestionClass q = queList.get(n);
        tvQueConter.setText((caunt++) + "/" + queList.size());
        tvQue.setText(q.getQue());
        btOpt1.setText("" + q.getOpt1()); // получает след вопросы
        btOpt2.setText("" + q.getOpt2());
        btOpt3.setText("" + q.getOpt3());
        btOpt4.setText("" + q.getOpt4());

        btOpt1.setBackgroundResource(R.drawable.vybor); // изменяет цвет кнопки
        btOpt2.setBackgroundResource(R.drawable.vybor);
        btOpt3.setBackgroundResource(R.drawable.vybor);
        btOpt4.setBackgroundResource(R.drawable.vybor);

        half.setOnClickListener(new View.OnClickListener() { //нажатие на кнопку 50/50
            @Override
            public void onClick(View view) {
                if (btOpt1.getText().equals(q.getRightOpt())) {
                    btOpt3.setVisibility(View.GONE);
                    btOpt2.setVisibility(View.GONE);
                } else if (btOpt2.getText().equals(q.getRightOpt())) {
                    btOpt1.setVisibility(View.GONE);
                    btOpt4.setVisibility(View.GONE);
                } else if (btOpt3.getText().equals(q.getRightOpt())) {
                    btOpt1.setVisibility(View.GONE);
                    btOpt2.setVisibility(View.GONE);
                } else if (btOpt4.getText().equals(q.getRightOpt())) {
                    btOpt3.setVisibility(View.GONE);
                    btOpt2.setVisibility(View.GONE);
                }
                half.setEnabled(false);
            }

        });

        btOpt1.setOnClickListener(new View.OnClickListener() { // нажатие на кнопку варианта А
            @Override
            public void onClick(View v) {

                if (btOpt1.getText().equals(q.getRightOpt())) { // Если ответили правильно
                    Toast.makeText(Menu.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    mViewModel.plus();// увеличить количество денег
                    if (conter < (queList.size() - 1)) {
                        conter++; //след вопрос
                        btOpt1.setBackgroundResource(R.color.colortrue); // изменить цвет кнопку
                        loadQuetions(conter);  // загрузить вопрос

                    } else { //если выиграл
                        Toast.makeText(Menu.this, "All Que Completed!", Toast.LENGTH_SHORT).show();
                        btOpt1.setBackgroundResource(R.drawable.vybor);
                        win_intent();
                    }

                } else {//если проиграл
                    intent(String.valueOf(sum), String.valueOf(conter)); //открыть активити
                }
                visible_btn();
            }
        });

        btOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt2.getText().equals(q.getRightOpt())) {
                    Toast.makeText(Menu.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    mViewModel.plus();
                    if (conter < (queList.size() - 1)) {
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(Menu.this, "All Que Completed!", Toast.LENGTH_SHORT).show();
                        btOpt2.setBackgroundResource(R.drawable.vybor);
                        win_intent();
                    }

                } else {
                    btOpt2.setBackgroundResource(R.color.colorfalse);
                    intent(String.valueOf(sum), String.valueOf(conter));
                }
                visible_btn();
            }
        });

        //btn 3
        btOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btOpt3.getText().equals(q.getRightOpt())) {
                    Toast.makeText(Menu.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    mViewModel.plus();
                    if (conter < (queList.size() - 1)) {
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(Menu.this, "All Que Completed!", Toast.LENGTH_SHORT).show();
                        win_intent();
                    }

                } else {
                    btOpt3.setBackgroundResource(R.color.colorfalse);
                    intent(String.valueOf(sum), String.valueOf(conter));
                }
                visible_btn();
            }
        });

        //btn4
        btOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btOpt4.getText().equals(q.getRightOpt())) {
                    Toast.makeText(Menu.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    mViewModel.plus();
                    if (conter < (queList.size() - 1)) {
                        conter++;
                        loadQuetions(conter);
                    } else {
                        Toast.makeText(Menu.this, "All Que Completed!", Toast.LENGTH_SHORT).show();
                        win_intent();
                    }
                } else {
                    btOpt4.setBackgroundResource(R.color.colorfalse);
                    intent(String.valueOf(sum), String.valueOf(conter));
                }
                visible_btn();
            }

        });
    }


    private void intent(String i, String j) { //открыть активити если проиграл
        Intent intent = new Intent(Menu.this, Res_sms.class);//открыть активити
        intent.putExtra(Res_sms.INPUT_KEY, i);// передача переменной
        intent.putExtra(Res_sms.INPUT_KEY2, j);
        startActivityForResult(intent, Res);
        finish();// нет пути нахад
    }

    private void win_intent() { //открыть если выиграл
        Intent intent = new Intent(Menu.this, Win_Result.class);
        startActivityForResult(intent, Res);
        finish();
    }
}
