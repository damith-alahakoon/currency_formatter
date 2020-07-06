# currency_formatter

How to use Currency formatter in  EditText

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.damith-alahakoon:currency_formatter:Tag'
	}
  
  ===========================================================================
  Sample code
  
     EditText editText_number=findViewById (R.id.editText_number);
        
        editText_number.addTextChangedListener(new CurrencyBuilder ()
                .setDecimalPlace (2) //decimal places Eg:- 100.00
                .setLocale(Locale.US)//locale default US
                .setSymbol(false)// currency symbol show if true 
                .create (editText_number));
