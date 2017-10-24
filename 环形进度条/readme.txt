attrs.xml 增加属性
    <declare-styleable name="DonutProgress">
        <attr name="donut_progress" format="float"/>
        <attr name="donut_max" format="integer"/>

        <attr name="donut_unfinished_color" format="color"/>
        <attr name="donut_finished_color" format="color"/>

        <attr name="donut_finished_stroke_width" format="dimension"/>
        <attr name="donut_unfinished_stroke_width" format="dimension"/>

        <attr name="donut_text_size" format="dimension"/>
        <attr name="donut_text_color" format="color"/>

        <attr name="donut_prefix_text" format="string"/>
        <attr name="donut_suffix_text" format="string"/>
        <attr name="donut_text" format="string"/>

        <attr name="donut_background_color" format="color"/>

        <attr name="donut_inner_bottom_text" format="string"/>
        <attr name="donut_inner_bottom_text_size" format="dimension"/>
        <attr name="donut_inner_bottom_text_color" format="color"/>

        <attr name="donut_circle_starting_degree" format="integer" />
        <attr name="donut_show_text" format="boolean"/>
        <attr name="donut_inner_drawable" format="reference"/>
    </declare-styleable>


使用方法 在布局xml中


        <org.pingchuan.dingwork.view.DonutProgress
            android:id="@+id/progressbar"
            android:layout_width="40dp"
            android:layout_height="40dp"
            android_custom:donut_finished_color="#23CCC0"    //背景色
            android_custom:donut_finished_stroke_width="5dp" //圆环的宽度
            android:backgroundTint="#23CCC0"
            android:backgroundTintMode="add"
            android_custom:donut_show_text="false"
            android_custom:donut_unfinished_color="#B4EDE9"    //前景色
            android_custom:donut_unfinished_stroke_width="5dp" //圆环的宽度
            android_custom:donut_circle_starting_degree="-90" //画圈的起始位置
            android:visibility="visible" />