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

    相对位置：当前view_目标view

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

    layout_marginStart
    layout_marginEnd
    layout_marginLeft
    layout_marginTop
    layout_marginRight
    layout_marginBottom

    gone margin：当前View与另一个View绑定后，另一个View的属性设置为了Gone，则以下属性会生效

    layout_goneMarginStart
    layout_goneMarginEnd
    layout_goneMarginLeft
    layout_goneMarginTop
    layout_goneMarginRight
    layout_goneMarginBottom

    bias：默认50%，结合居中显示使用

    layout_constraintHorizontal_bias：水平居中的百分比偏移
    layout_constraintVertical_bias：垂直居中的百分比偏移

    Circular positioning：以当前view的中心为坐标原点，在半径和角度对应的位置上绘制另一个view

    layout_constraintCircle：id，对应于目标坐标view
    layout_constraintCircleAngle：角度，0-360的值
    layout_constraintCircleRadius：半径

![circle](/img/circle1.png)   ![circle](/img/circle2.png)

    min/max：当宽或者高为wrap_content时，可以使用min/max
    且布局宽高在min-max之间

    minWidth
    minHeight
    maxWidth
    maxHeight


    Widgets dimension constraints（宽高约束）
    1、使用具体值限制宽高（100dp）
    2、使用wrap_content，让布局自己计算宽高
    3、0dp，相当于"MATCH_CONSTRAINT"，占满全屏

    0dp需要结合
    layout_constraintLeft_toLeftOf
    layout_constraintRight_toRightOf…
    使用


    WRAP_CONTENT : enforcing constraints（强制约束）
    当其中一个布局宽或者高设置为wrap_content时，如果其宽或者高超出其限制范围，
    可以添加下面的属性，来强制限制其在约束的范围内
    （参考activity_constraint_layout_two中97行）

    layout_constrainedWidth
    layout_constrainedHeight


    MATCH_CONSTRAINT dimensions （占用所有可用空间可用修饰）
    （参考activity_constraint_layout_two中116行）

    设置最大最小宽高范围，作用范围可以是dp具体值，或者wrap，MATCH_CONSTRAINT
    layout_constraintWidth_min
    layout_constraintHeight_min
    layout_constraintWidth_max
    layout_constraintHeight_max
    设置parent宽或高的百分比为其宽或高的大小，需要设置
    layout_constraintWidth_default
    layout_constraintHeight_default
    的值为percent，取值范围为0-1
    layout_constraintWidth_percent
    layout_constraintHeight_percent


