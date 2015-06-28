package com.example.smsblocker;

import java.util.Set;
import java.util.HashSet;

import android.content.Context;
import android.content.SharedPreferences;

public class FilteredString {

	private static final String PREF_KEY = "filtered_strings";
	private static final String DATA_KEY = "filtered_strings_data";

	public static void AddFilteredString(Context context, String filteredString) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE);
		Set<String> list = pref.getStringSet(DATA_KEY, new HashSet<String>());
		list.add(filteredString);
		pref.edit().putStringSet(DATA_KEY, list).commit();
	}

	public static Set<String> getFilteredStrings(Context context) {
		return context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE).getStringSet(DATA_KEY, new HashSet<String>());
	}

	public static void removeFilteredString(Context context, String removedString) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE);
		Set<String> list = pref.getStringSet(DATA_KEY, new HashSet<String>());
		list.remove(removedString);
		pref.edit().putStringSet(DATA_KEY, list).commit();
	}

	public static void clearFilterStringList(Context context) {
		SharedPreferences pref = context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE);
		pref.edit().putStringSet(DATA_KEY, new HashSet<String>()).commit();
	}

}
