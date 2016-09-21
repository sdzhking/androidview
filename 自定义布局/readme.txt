<?xml version="1.0" encoding="utf-8"?>
<!--
shape drawable xml�ļ��ж����һ������ͼ�Σ�������res/drawable/Ŀ¼�£��ļ���filename��Ϊ���ʵ���ԴID
�ڴ�����ͨ��R.drawable.filename���з��ʣ���xml�ļ���ͨ��@[package:]drawable/filename���з��ʡ�

-->
<!--
     android:shape=["rectangle" | "oval" | "line" | "ring"]
     shape����״��Ĭ��Ϊ���Σ���������Ϊ���Σ�rectangle������Բ��(oval)��������״(line)������(ring)
  ���������ֻ����android:shape="ringʱ���ã�
  android:innerRadius �ߴ磬�ڻ��İ뾶��
  android:innerRadiusRatio    �����ͣ��Ի��Ŀ�ȱ�������ʾ�ڻ��İ뾶��
  ���磬���android:innerRadiusRatio����ʾ�ڻ��뾶���ڻ��Ŀ�ȳ���5�����ֵ�ǿ��Ա����ǵģ�Ĭ��Ϊ9.
  android:thickness     �ߴ磬���ĺ��
  android:thicknessRatio     �����ͣ��Ի��Ŀ�ȱ�������ʾ���ĺ�ȣ����磬���android:thicknessRatio="2"��
  ��ô���ĺ�Ⱦ͵��ڻ��Ŀ�ȳ���2�����ֵ�ǿ��Ա�android:thickness���ǵģ�Ĭ��ֵ��3.
  android:useLevel     booleanֵ�����������LevelListDrawableʹ��ʱֵΪtrue������Ϊfalse.

-->
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle" >

    <!--
         Բ��
         android:radius       ���� �뾶
      android:topLeftRadius       ���� ���Ͻǰ뾶
      android:topRightRadius      ���� ���Ͻǰ뾶
      android:bottomLeftRadius ���� ���½ǰ뾶
      android:bottomRightRadius ���� ���½ǰ뾶

    -->
    <corners
        android:bottomLeftRadius="20dp"
        android:bottomRightRadius="25dp"
        android:radius="8dp"
        android:topLeftRadius="5dp"
        android:topRightRadius="15dp" />

    <!--
        ����ɫ
        android:startColor  ��ɫֵ ��ʼ��ɫ
        android:endColor    ��ɫֵ ������ɫ
        android:centerColor ����   �����м���ɫ������ʼ��ɫ�������ɫ֮�����ɫ
        android:angle       ����   ����Ƕ�(PS����angle=0ʱ������ɫ�Ǵ������ҡ� Ȼ����ʱ�뷽��ת����angle=90ʱΪ�������ϡ�angle����Ϊ45��������)
        android:type        ["linear" | "radial" | "sweep"] ��������(ȡֵ��linear��radial��sweep)
                            linear ���Խ��䣬����Ĭ������
                            radial �����Խ��䣬�Կ�ʼɫΪ���ġ�
                            sweep ɨ����ʽ�Ľ��䡣
       android:useLevel   ["true" | "false"] ���Ҫʹ��LevelListDrawable���󣬾�Ҫ����Ϊtrue������Ϊtrue�޽��䡣false�н���ɫ
       android:gradientRadius ���� ����ɫ�뾶.�� android:type="radial" ʱ��ʹ�á�����ʹ�� android:type="radial"�ᱨ��
       android:centerX        ����   ��������X����������λ��
       android:centerY   ����   ��������Y����������λ��

    -->
    <gradient
        android:angle="45"
        android:endColor="#80FF00FF"
        android:startColor="#FFFF0000" />

    <!--
          �ڱ߾࣬��������ߵľ��� 
          android:left      ���� ���ڱ߾�
          android:top   ���� ���ڱ߾�
          android:right      ���� ���ڱ߾�
          android:bottom ���� ���ڱ߾�

    -->
    <padding
        android:bottom="10dp"
        android:left="10dp"
        android:right="10dp"
        android:top="10dp" />

    <!--
       size ��С
       android:width ���� ���
       android:height ���� �߶�

    -->
    <size android:width="600dp" />

    <!--
        �ڲ����
        android:color ��ɫֵ �����ɫ

    -->
    <solid android:color="#ffff9d77" />

    <!--
         ���
         android:width ���� ��ߵĿ��
         android:color ��ɫֵ ��ߵ���ɫ
         android:dashWidth ���� ��ʾ��ߵ���ʽ�����ߵĿ�ȣ� ֵΪ0ʱ����ʾΪʵ�ߡ�ֵ����0��Ϊ���ߡ�
         android:dashGap      ���� ��ʾ���Ϊ����ʱ������֮��ļ�� ���� - - - - ��

    -->
    <stroke
        android:width="2dp"
        android:color="#dcdcdc" />

</shape>