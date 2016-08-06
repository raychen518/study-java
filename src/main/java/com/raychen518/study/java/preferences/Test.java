package com.raychen518.study.java.preferences;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.UUID;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

public class Test {

	public static void main(String[] args)
			throws BackingStoreException, IOException, InvalidPreferencesFormatException {
		// Note: It is necessary to run the program as the administrator,
		// otherwise some code cannot work normally.

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Index
		// - Reading and Setting Preferences
		// --- User Package Node
		// --- User Root Node
		// --- System Package Node
		// --- System Root Node
		// --- Custom Node
		// --- Different Data Types
		// - Removing Preferences
		// - Preferences Keys
		// - Exporting Preferences
		// - Importing Preferences
		// - Misc
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// =============================
		// Reading and Setting Preferences
		// =============================
		// =================================================
		// User Package Node
		// =================================================
		{
			System.out.println("--------------------------------------------------------------------");
			Preferences preferences = Preferences.userNodeForPackage(Test.class);

			String preferenceKey = "user_package_node_key_" + UUID.randomUUID().toString();
			String preferenceValue = "user_package_node_value";
			String preferenceDefaultValue = "user_package_node_defaultValue";

			System.out.println("preferences.get(preferenceKey, preferenceDefaultValue): "
					+ preferences.get(preferenceKey, preferenceDefaultValue));
			preferences.put(preferenceKey, preferenceValue);
			System.out.println("preferences.get(preferenceKey, preferenceDefaultValue): "
					+ preferences.get(preferenceKey, preferenceDefaultValue));

			System.out.println(
					"Preference Location: HKEY_CURRENT_USER\\SOFTWARE\\JavaSoft\\Prefs\\{CURRENT_CLASS_PACKAGE}");

			// If the above "preferences.put(...)" statement is executed in
			// Windows, then the set preference can be found at following
			// location in the Windows registry.
			// -----------------------------------------------------------------
			// HKEY_CURRENT_USER\SOFTWARE\JavaSoft\Prefs\{CURRENT_CLASS_PACKAGE}
			// -----------------------------------------------------------------
			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}

		// =================================================
		// User Root Node
		// =================================================
		{
			System.out.println("--------------------------------------------------------------------");
			Preferences preferences = Preferences.userRoot();

			String preferenceKey = "user_root_node_key_" + UUID.randomUUID().toString();
			String preferenceValue = "user_root_node_value";
			String preferenceDefaultValue = "user_root_node_defaultValue";

			System.out.println("preferences.get(preferenceKey, preferenceDefaultValue): "
					+ preferences.get(preferenceKey, preferenceDefaultValue));
			preferences.put(preferenceKey, preferenceValue);
			System.out.println("preferences.get(preferenceKey, preferenceDefaultValue): "
					+ preferences.get(preferenceKey, preferenceDefaultValue));

			System.out.println("Preference Location: HKEY_CURRENT_USER\\SOFTWARE\\JavaSoft\\Prefs");

			// If the above "preferences.put(...)" statement is executed in
			// Windows, then the set preference can be found at following
			// location in the Windows registry.
			// -----------------------------------------------------------------
			// HKEY_CURRENT_USER\SOFTWARE\JavaSoft\Prefs
			// -----------------------------------------------------------------
			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}

		// =================================================
		// System Package Node
		// =================================================
		{
			System.out.println("--------------------------------------------------------------------");
			Preferences preferences = Preferences.systemNodeForPackage(Test.class);

			String preferenceKey = "system_package_node_key_" + UUID.randomUUID().toString();
			String preferenceValue = "system_package_node_value";
			String preferenceDefaultValue = "system_package_node_defaultValue";

			System.out.println("preferences.get(preferenceKey, preferenceDefaultValue): "
					+ preferences.get(preferenceKey, preferenceDefaultValue));
			preferences.put(preferenceKey, preferenceValue);
			System.out.println("preferences.get(preferenceKey, preferenceDefaultValue): "
					+ preferences.get(preferenceKey, preferenceDefaultValue));

			System.out.println(
					"Preference Location: HKEY_LOCAL_MACHINE\\SOFTWARE\\JavaSoft\\Prefs\\{CURRENT_CLASS_PACKAGE}");

			// If the above "preferences.put(...)" statement is executed in
			// Windows, then the set preference can be found at following
			// location in the Windows registry.
			// -----------------------------------------------------------------
			// HKEY_LOCAL_MACHINE\SOFTWARE\JavaSoft\Prefs\{CURRENT_CLASS_PACKAGE}
			// -----------------------------------------------------------------
			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}

		// =================================================
		// System Root Node
		// =================================================
		{
			System.out.println("--------------------------------------------------------------------");
			Preferences preferences = Preferences.systemRoot();

			String preferenceKey = "system_root_node_key_" + UUID.randomUUID().toString();
			String preferenceValue = "system_root_node_value";
			String preferenceDefaultValue = "system_root_node_defaultValue";

			System.out.println("preferences.get(preferenceKey, preferenceDefaultValue): "
					+ preferences.get(preferenceKey, preferenceDefaultValue));
			preferences.put(preferenceKey, preferenceValue);
			System.out.println("preferences.get(preferenceKey, preferenceDefaultValue): "
					+ preferences.get(preferenceKey, preferenceDefaultValue));

			System.out.println("Preference Location: HKEY_LOCAL_MACHINE\\SOFTWARE\\JavaSoft\\Prefs");

			// If the above "preferences.put(...)" statement is executed in
			// Windows, then the set preference can be found at following
			// location in the Windows registry.
			// -----------------------------------------------------------------
			// HKEY_LOCAL_MACHINE\SOFTWARE\JavaSoft\Prefs
			// -----------------------------------------------------------------
			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}

		// =================================================
		// Custom Node
		// =================================================
		{
			System.out.println("--------------------------------------------------------------------");
			Preferences preferences = Preferences.userNodeForPackage(Test.class);

			String customNodePath = "/xx1/xx2/xx3";
			preferences = preferences.node(customNodePath);

			String preferenceKey = "custom_node_key_" + UUID.randomUUID().toString();
			String preferenceValue = "custom_node_value";
			String preferenceDefaultValue = "custom_node_defaultValue";

			System.out.println("preferences.get(preferenceKey, preferenceDefaultValue): "
					+ preferences.get(preferenceKey, preferenceDefaultValue));
			preferences.put(preferenceKey, preferenceValue);
			System.out.println("preferences.get(preferenceKey, preferenceDefaultValue): "
					+ preferences.get(preferenceKey, preferenceDefaultValue));

			System.out.println("Preference Location: HKEY_CURRENT_USER\\SOFTWARE\\JavaSoft\\Prefs"
					+ customNodePath.replace("/", "\\"));
			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}

		// =================================================
		// Different Data Types
		// =================================================
		{
			System.out.println("--------------------------------------------------------------------");
			Preferences preferences = Preferences.userNodeForPackage(Test.class);

			preferences.put("string_value", "abc");
			preferences.putInt("int_value", 123);
			preferences.putBoolean("boolean_value", true);
			preferences.putByteArray("byte_array_value", "Hello, World!".getBytes());

			System.out.println(preferences.get("string_value", ""));
			System.out.println(preferences.getInt("int_value", 0));
			System.out.println(preferences.getBoolean("boolean_value", false));
			System.out.println(preferences.getByteArray("byte_array_value", null));
			System.out.println(new String(preferences.getByteArray("byte_array_value", null)));

			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}

		// =============================
		// Removing Preferences
		// =============================
		{
			System.out.println("--------------------------------------------------------------------");
			Preferences preferences = Preferences.userRoot();

			String childPreferencesPathName = UUID.randomUUID().toString();
			System.out.println("childPreferencesPathName: " + childPreferencesPathName);

			System.out.println("preferences.nodeExists(childPreferencesPathName): "
					+ preferences.nodeExists(childPreferencesPathName));
			Preferences childPreferences = preferences.node(childPreferencesPathName);
			System.out.println("preferences.nodeExists(childPreferencesPathName): "
					+ preferences.nodeExists(childPreferencesPathName));

			System.out.println(
					"childPreferences.get(\"key\", \"defaultValue\"): " + childPreferences.get("key", "defaultValue"));
			childPreferences.put("key", "value");
			System.out.println(
					"childPreferences.get(\"key\", \"defaultValue\"): " + childPreferences.get("key", "defaultValue"));
			childPreferences.remove("key");
			System.out.println(
					"childPreferences.get(\"key\", \"defaultValue\"): " + childPreferences.get("key", "defaultValue"));

			childPreferences.removeNode();
			System.out.println("preferences.nodeExists(childPreferencesPathName): "
					+ preferences.nodeExists(childPreferencesPathName));

			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}

		// =============================
		// Preferences Keys
		// =============================
		{
			System.out.println("--------------------------------------------------------------------");
			Preferences preferences = Preferences.userRoot();

			String childPreferencesPathName = UUID.randomUUID().toString();
			System.out.println("childPreferencesPathName: " + childPreferencesPathName);

			Preferences childPreferences = preferences.node(childPreferencesPathName);

			System.out.println("childPreferences.keys().length: " + childPreferences.keys().length);
			for (String preferencesKey : childPreferences.keys()) {
				System.out.println(preferencesKey);
			}

			childPreferences.node("a1");
			childPreferences.node("b2");
			childPreferences.node("c3");

			System.out.println("childPreferences.keys().length: " + childPreferences.keys().length);
			for (String preferencesKey : childPreferences.keys()) {
				System.out.println(preferencesKey);
			}

			childPreferences.put("key1", "value1");
			childPreferences.put("key2", "value2");
			childPreferences.put("key3", "value3");

			System.out.println("childPreferences.keys().length: " + childPreferences.keys().length);
			System.out.println("Arrays.toString(childPreferences.keys()): " + Arrays.toString(childPreferences.keys()));
			for (String preferencesKey : childPreferences.keys()) {
				System.out.println(preferencesKey);
			}

			childPreferences.removeNode();

			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}

		// =============================
		// Exporting Preferences
		// =============================
		{
			System.out.println("--------------------------------------------------------------------");
			Preferences preferences = Preferences.userRoot();

			String childPreferencesPathName = UUID.randomUUID().toString();
			System.out.println("childPreferencesPathName: " + childPreferencesPathName);

			Preferences childPreferences = preferences.node(childPreferencesPathName);

			childPreferences.put("key1", "value1");
			childPreferences.put("key2", "value2");
			childPreferences.put("key3", "value3");

			Preferences childA1Preferences = childPreferences.node("a1");
			childA1Preferences.put("a1_key1", "a1_value1");
			childA1Preferences.put("a1_key2", "a1_value2");
			childA1Preferences.put("a1_key3", "a1_value3");

			Preferences childB2Preferences = childPreferences.node("b2");
			childB2Preferences.put("b2_key1", "b2_value1");
			childB2Preferences.put("b2_key2", "b2_value2");
			childB2Preferences.put("b2_key3", "b2_value3");

			Preferences childC3Preferences = childPreferences.node("c3");
			childC3Preferences.put("b3_key1", "b3_value1");
			childC3Preferences.put("b3_key2", "b3_value2");
			childC3Preferences.put("b3_key3", "b3_value3");

			{
				String exportFilePath = System.getProperty("user.home") + "\\preferences_excluding_subnodes.xml";
				OutputStream outputStream = new FileOutputStream(exportFilePath);

				childPreferences.exportNode(outputStream);

				System.out.println(
						"The preferences excluding sub-nodes have been exported to the location: " + exportFilePath);
				outputStream.close();
			}

			{
				String exportFilePath = System.getProperty("user.home") + "\\preferences_including_subnodes.xml";
				OutputStream outputStream = new FileOutputStream(exportFilePath);

				childPreferences.exportSubtree(outputStream);

				System.out.println(
						"The preferences including sub-nodes have been exported to the location: " + exportFilePath);
				outputStream.close();
			}

			childPreferences.removeNode();

			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}

		// =============================
		// Importing Preferences
		// =============================
		{
			System.out.println("--------------------------------------------------------------------");
			Preferences preferences = Preferences.userRoot();

			String childPreferencesPathName = UUID.randomUUID().toString();
			System.out.println("childPreferencesPathName: " + childPreferencesPathName);

			Preferences childPreferences = preferences.node(childPreferencesPathName);

			childPreferences.put("key1", "value1");
			childPreferences.put("key2", "value2");
			childPreferences.put("key3", "value3");

			Preferences childA1Preferences = childPreferences.node("a1");
			childA1Preferences.put("a1_key1", "a1_value1");
			childA1Preferences.put("a1_key2", "a1_value2");
			childA1Preferences.put("a1_key3", "a1_value3");

			Preferences childB2Preferences = childPreferences.node("b2");
			childB2Preferences.put("b2_key1", "b2_value1");
			childB2Preferences.put("b2_key2", "b2_value2");
			childB2Preferences.put("b2_key3", "b2_value3");

			Preferences childC3Preferences = childPreferences.node("c3");
			childC3Preferences.put("b3_key1", "b3_value1");
			childC3Preferences.put("b3_key2", "b3_value2");
			childC3Preferences.put("b3_key3", "b3_value3");

			String exportFilePath = System.getProperty("user.home") + "\\preferences.xml";
			OutputStream outputStream = new FileOutputStream(exportFilePath);
			childPreferences.exportSubtree(outputStream);
			System.out.println("The preferences of the node [" + childPreferences.absolutePath()
					+ "] have been exported to the location: " + exportFilePath);
			outputStream.close();

			System.out.println("preferences.nodeExists(childPreferencesPathName): "
					+ preferences.nodeExists(childPreferencesPathName));
			childPreferences.removeNode();
			System.out.println("preferences.nodeExists(childPreferencesPathName): "
					+ preferences.nodeExists(childPreferencesPathName));

			InputStream inputStream = new FileInputStream(exportFilePath);
			Preferences.importPreferences(inputStream);
			inputStream.close();
			System.out.println("preferences.nodeExists(childPreferencesPathName): "
					+ preferences.nodeExists(childPreferencesPathName));

			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}

		// =============================
		// Misc
		// =============================
		{
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Preferences.MAX_NAME_LENGTH: " + Preferences.MAX_NAME_LENGTH);
			System.out.println("Preferences.MAX_KEY_LENGTH: " + Preferences.MAX_KEY_LENGTH);
			System.out.println("Preferences.MAX_VALUE_LENGTH: " + Preferences.MAX_VALUE_LENGTH);
			System.out.println();

			Preferences preferences = Preferences.userNodeForPackage(Test.class);
			preferences = preferences.node("/xx1/xx2/xx3");

			System.out.println("preferences: " + preferences);
			System.out.println("preferences.absolutePath(): " + preferences.absolutePath());
			System.out.println("preferences.name(): " + preferences.name());
			System.out.println("preferences.isUserNode(): " + preferences.isUserNode());
			System.out.println();

			System.out.println("Arrays.toString(Preferences.userRoot().childrenNames()): "
					+ Arrays.toString(Preferences.userRoot().childrenNames()));
			System.out.println(
					"Preferences.userRoot().nodeExists(\"temp\"): " + Preferences.userRoot().nodeExists("temp"));
			System.out.println(
					"Preferences.userRoot().nodeExists(\"temp\"): " + Preferences.userRoot().nodeExists("/xx1/xx2"));
			System.out.println("Preferences.userRoot().nodeExists(UUID.randomUUID().toString()): "
					+ Preferences.userRoot().nodeExists(UUID.randomUUID().toString()));

			System.out.println("--------------------------------------------------------------------");
			System.out.println();
		}
	}

}
