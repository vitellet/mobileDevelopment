package vitelle.descriptor;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> terms;
    HashMap<String,String> definitions;
    CardView card;
    TextView title;
    TextView description;
    Random random = new Random();
    Animation animation;
    int cursor;

    public void buildTerms(){
        terms = new ArrayList<>();
        terms.add("CVS");terms.add("SaaS");terms.add("AJAX");terms.add("API");terms.add("CSS");terms.add("FIFO");terms.add("IDE");terms.add("J2EE");terms.add("JDK");terms.add("JS");
        terms.add("jSON");terms.add("LIFO");terms.add("MVC");terms.add("OOP");terms.add("SDK");terms.add("CRUD");terms.add("FTP");terms.add("LAMP");terms.add("REST");terms.add("QA");
        terms.add("NP-C");terms.add("AGILE");terms.add("Confluence");terms.add("JIRA");terms.add("JIT");terms.add("Struct");terms.add("Prebinding");terms.add("Microkernel");
        terms.add("MBR");terms.add("Kernel");terms.add("ISR");terms.add("Design Pattern");terms.add("WDDM");terms.add("SMB");
    }

    public void buildDefinitions(){
        definitions = new HashMap<>();
        definitions.put("CVS", "Concurrent Version System - A source code control system");
        definitions.put("SaaS", "Software as a Service - Software that is available online and accessed by users as needed");
        definitions.put("AJAX", "Asynchronous JavaScript and XML - A group of web development techniques to let you create asynchronous applications");
        definitions.put("API", "Application Programming Interface - An external interface from an application that other applications can access");
        definitions.put("CSS", "Cascading Style Sheets - A language used to organize and design how a website looks");
        definitions.put("FIFO", "First In First Out - A queuing method that says the first item in is the first item out");
        definitions.put("IDE", "Integrated Development Environment - Software that allows developers to write code");
        definitions.put("J2EE", "Java 2 Enterprise Edition - A version of Java that is made for enterprise applications");
        definitions.put("JDK", "Java Development Kit - The software used to develop Java applications");
        definitions.put("JS", "JavaScript - A client-side scripting language used to develop web applications");
        definitions.put("jSON", "JavaScript Object Notation - A lightweight data interchange format");
        definitions.put("LIFO", "Last In First Out - A queuing method that says the last item in is the first item out");
        definitions.put("MVC", "Model View Controller - A software design that includes three levels of modules");
        definitions.put("OOP", "Object Oriented Programming - Writing code and designing programs as a collection of smaller objects that interact with each other");
        definitions.put("SDK", "Software Development Kit - A collection of tools that allows developers to write code in a particular language");
        definitions.put("FTP", "File Transfer Protocol - Protocol designed for transferring files over the web from a client to server.");
        definitions.put("LAMP", "Linux Apache MySQL PHP - Open source software stack using aforementioned tools");
        definitions.put("REST", "Representational State Transfer - Web service communication protocols. Suppports variety of formats, uses less bandwidth, faster than SOAP");
        definitions.put("QA", "Quality Assurance - Testing code for defects before releasing it to its audience");
        definitions.put("NP-C", "In computational complexity theory, an NP-complete decision problem is one belonging to both the NP and the NP-hard complexity classes. In this context, NP stands for nondeterministic polynomial time");
        definitions.put("AGILE", "A method of project management, used especially for software development, that is characterized by the division of tasks into short phases of work and frequent reassessment and adaptation of plans");
        definitions.put("Confluence", "A property of rewriting systems, describing which terms in such a system can be rewritten in more than one way, to yield the same result");
        definitions.put("JIRA", "Jira is a proprietary issue tracking product, developed by Atlassian. It provides bug tracking, issue tracking, and project management functions");
        definitions.put("JIT", "just-in-time (JIT) compilation, (also dynamic translation or run-time compilation), is a way of executing computer code that involves compilation during execution of a program – at run time – rather than prior to execution. Most often, this consists of source code or more commonly bytecode translation to machine code, which is then executed directly.");
        definitions.put("Struct", "A data type available in C programming languages, such as C, C++, and C#. It is a user-defined data type that can store multiple related items.");
        definitions.put("Prebinding", "an optimization process that allows faster launching of applications in Mac OS X.");
        definitions.put("Microkernel", "a minimalistic kernel designed to be as small as possible. It contains only the basic code needed to communicate with hardware and load an operating system.");
        definitions.put("MBR", "Master Boot Record - An MBR is a small section of a hard disk or other storage device that contains information about the disk. It is located in the boot sector and defines the disk partitions as well as the code used to start the boot sequence.");
        definitions.put("Kernel", "A kernel is the foundational layer of an operating system (OS). It functions at a basic level, communicating with hardware and managing resources, such as RAM and the CPU.");
        definitions.put("ISR", "Interrupt Service Routine - An ISR (also called an interrupt handler) is a software process invoked by an interrupt request from a hardware device. It handles the request and sends it to the CPU, interrupting the active process. When the ISR is complete, the process is resumed.");
        definitions.put("Design Pattern", "reusable solutions for software development. They serve as templates that programmers can use when creating applications.");
        definitions.put("WDDM", "Windows Display Driver Model - WDDM is a display driver architecture introduced with Windows Vista. It improves graphics performance over the previous Windows XP architecture by more fully utilizing a computer's GPU to render system graphics.");
        definitions.put("SMB", "Server Message Block - SMB is a network protocol used by Windows-based computers that allows systems within the same network to share files.");
    }

    public void cardAnimation(){
        animation = new TranslateAnimation(0,-2000,0,0);
        animation.setDuration(500);
        animation.setFillAfter(false);

        card.startAnimation(animation);
    }



    public void nextCard(){

        cursor = random.nextInt(terms.size());
        title.setText(terms.get(cursor));
        description.setText(definitions.get(terms.get(cursor)));
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("deScriptr");
        title = findViewById(R.id.titleTextView);
        description = findViewById(R.id.descriptionTextView);
        card = findViewById(R.id.termCardView);

        buildTerms();
        buildDefinitions();

        

        cursor = random.nextInt(terms.size());
        title.setText(terms.get(cursor));
        description.setText(definitions.get(terms.get(cursor)));


        card.setOnTouchListener(new OnSwipeTouchListener(null) {
            @Override
            public void onSwipeLeft() {
                Log.i("Swipe Card","Left");
                cardAnimation();
                nextCard();


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.title1:
                if(item.isChecked()){
                    item.setChecked(false);
                    //do some shit
                }else{
                    item.setChecked(true);
                    //do some shit
                }
            case R.id.title2:
                if(item.isChecked()){
                    item.setChecked(false);
                    //do some shit
                }else {
                    item.setChecked(true);
                    //do some shit
                }
            case R.id.title3:
                if(item.isChecked()){
                    item.setChecked(false);
                    //do some shit
                }else {
                    item.setChecked(true);
                    //do some shit
                }
            default:
                return super.onOptionsItemSelected(item);


        }

    }
}
