package com.example.user11.quiz;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "triviaQuiz";
	// tasks table name
	private static final String TABLE_QUEST = "quest";
	// tasks Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer"; //correct option
	private static final String KEY_OPTA= "opta"; //option a
	private static final String KEY_OPTB= "optb"; //option b
	private static final String KEY_OPTC= "optc"; //option c
	private SQLiteDatabase dbase;
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase=db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
				+KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
		db.execSQL(sql);		
		addQuestions();
		//db.close();
	}
	private void addQuestions()
	{
		Question q1=new Question("What is the first book in the old " +
				" Testament?","Luke", "Titus", "Genesis", "Genesis");
		this.addQuestion(q1);
		Question q2=new Question("He denied Jesus before His " +
				"crucification?", "Peter", "John", "Judas", "Judas");
		this.addQuestion(q2);
		Question q3=new Question("What is the first book in the new" +
				" testament?","Luke", "Mathews","Daniel","Mathews");
		this.addQuestion(q3);
		Question q4=new Question("Who is regarded the most wise king in the bible" +
				" bible?",	"King Solomon", "King David", "King Herod","King Solomon");
		this.addQuestion(q4);
		Question q5=new Question("who in the bible changed water into " +
				" wine?","Moses","Jesus","Paul","Jesus");
		this.addQuestion(q5);
		Question q6=new Question("How many desciples " +
				" did Jesus have?","6","8","12","12");
		this.addQuestion(q6);
		Question q7=new Question("Who was Jesus' " +
				" father?","Samuel", "Jacob", "Joseph", "Joseph");
		this.addQuestion(q7);
		Question q8=new Question("The last book in the bible  " +
				"bible?", "Jude", "Revelation", "Genesis", "Revelation");
		this.addQuestion(q8);
		Question q9=new Question("The place where Jesus was " +
				" crucified?","Golgoltha", "Jerusalem","Gethsemane","Golgoltha");
		this.addQuestion(q9);
		Question q10=new Question("She is the mother of " +
				" Jesus",	"Mary", "Magdeline", "Mariam","Mary");
		this.addQuestion(q10);
		Question q11=new Question("Which planet is the  " +
				" biggest?","Neptune","Uranus","Jupiter","Jupiter");
		this.addQuestion(q11);
		Question q12=new Question("Which planet is the closest from the " +
				" sun?","Earth","Pluto","Neptune","Earth");
		this.addQuestion(q12);
		Question q13=new Question("First man to land on the " +
				"moon?", "Erdwin Aldrin", "Mark Shuttleworth", "Paul London ", "Erdwin Aldrin");
		this.addQuestion(q13);
		Question q14=new Question("Which planet is the " +
				" smallest?","Venus", "Earth","jupiter","Venus");
		this.addQuestion(q14);
		Question q15=new Question("what's the name of earth's " +
				" moon?",	"Moon", "Titan", "Sao","Moon");
		this.addQuestion(q15);
		Question q16=new Question("How far is the earth from the " +
				" sun?","29 million miles","93 million miles","66 million miles","93 million miles");
		this.addQuestion(q16);
		Question q17=new Question("Which is not a type of " +
				" star?","White Giant","Neutron Star","Yellow Dwarf","White Giant");
		this.addQuestion(q17);
		Question q18=new Question("Which star is the  " +
				"brightest?", "Betelgeuse", "Sirius", "Regulus", "Sirius");
		this.addQuestion(q18);
		Question q19=new Question("Who proposed the 3 laws of planetary " +
				" motion?","Nicolaus Copernicus", "Johannes Kepler","Carl Sagan","Johannes Kepler");
		this.addQuestion(q19);
		Question q20=new Question("sequence of planets from the " +
				" sun?",	"mercury, Venus, Earth", "Mars, Mercury, Jupiter", "Mars,Mercury,Venus","mercury, Venus, Earth");
		this.addQuestion(q20);

	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		// Create tables again
		onCreate(db);
	}
	// Adding new question
	public void addQuestion(Question quest) {
		//SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQUESTION()); 
		values.put(KEY_ANSWER, quest.getANSWER());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_OPTC, quest.getOPTC());
		// Inserting Row
		dbase.insert(TABLE_QUEST, null, values);		
	}
	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase=this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setOPTC(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
	}
	public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}
}
