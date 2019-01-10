### Constraint layout 学习

> 引入 ConstraintLayout 最新的版本，目前是2.0.0-alpha1版本

    需要将appcompat-v7版本与targetSdkVersion和constraint对应的版本一致
    最低版本支持minSdkVersion是18

    implementation 'com.android.support:appcompat-v7:27.0.2'
    implementation 'com.android.support.constraint:constraint-layout:2.0.0-alpha1'

###### 简单使用

    创建新的布局时，系统会默认自动生成ConstraintLayout为根布局的XML文件
    ConstraintLayout继承自ViewGroup，因此是一个容器
    一般情况下，只需要一层ConstraintLayout即可实现复杂的布局结构

    基本属性：（不一一介绍）具体使用可参考activity_constraint_layout_easy_use.xml
    目标view可以是 parent，表示父布局

    相对位置

    layout_constraintLeft_toLeftOf：view的左侧与目标view的左侧对齐
    layout_constraintLeft_toRightOf：view的左侧与目标view的右侧对齐
    layout_constraintRight_toLeftOf
    layout_constraintRight_toRightOf
    layout_constraintTop_toTopOf
    layout_constraintTop_toBottomOf
    layout_constraintBottom_toTopOf
    layout_constraintBottom_toBottomOf
    layout_constraintBaseline_toBaselineOf
    layout_constraintStart_toEndOf
    layout_constraintStart_toStartOf
    layout_constraintEnd_toStartOf
    layout_constraintEnd_toEndOf

    margin

    android:layout_marginStart
    android:layout_marginEnd
    android:layout_marginLeft
    android:layout_marginTop
    android:layout_marginRight
    android:layout_marginBottom
