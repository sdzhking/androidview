使用方式
样例：
++yourpakage.view++ 替换成你的自定义控件放置的包名

<++yourpakage.view++.ShowPwdEditText
	android:id="@+id/newpassword2"
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	android:layout_gravity="center_vertical"
	android:layout_marginLeft="13dp"
	android:background="@null"
	android:hint="@string/new_pwd_again"
	android:inputType="textPassword"
	android:maxLines="1"
	android:singleLine="true"
	android:textSize="@dimen/textsize_8"
	android:drawableRight="@drawable/bg_pwd_show_hide"
	android:paddingRight="10dp"
	/>