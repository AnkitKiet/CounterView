# CounterView
This is an Android library for UI which can be used as a counter view as in Flipkart, Shopclues, Myntra etc. This is highly customizable and is very simple to integrate.
## Preview

![Sample](/screenshot.gif?raw=true "Preview")

## Installation
### Gradle
Add below code in build.gradle
```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
		}
	}
```
Add a dependency
```
dependencies {
        compile 'com.github.AnkitKiet:CounterView:1.2'
	}
```

### Maven
Add below code for Maven installation
```
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
Add a dependency
```
<dependency>
	    <groupId>com.github.AnkitKiet</groupId>
	    <artifactId>CounterView</artifactId>
	    <version>1.2</version>
	</dependency>
```

## How To Use

paste below code in java file

```
        CounterView cv = (CounterView) findViewById(R.id.cv);
        cv.setStartCounterValue("1");
        cv.setColor(R.color.colorPrimaryDark, R.color.colorPrimary, R.color.colorAccent);
        cv.setCounterListener(new CounterListner() {
            @Override
            public void onIncClick(String s) {

                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
//    Perform Anything
            }

            @Override
            public void onDecClick(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
		//Perform Anything
            }
        });

```
paste below code in layout xml file.
```
  <edu.counterview.CounterView
        android:id="@+id/cv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

```


## License
```
Copyright 2017 Ankit Maurya

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
