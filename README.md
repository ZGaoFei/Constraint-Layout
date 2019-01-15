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
    layout_constraintStart_toEndOf
    layout_constraintStart_toStartOf
    layout_constraintEnd_toStartOf
    layout_constraintEnd_toEndOf
    layout_constraintBaseline_toBaselineOf：文字底部对齐,与alignBaseLine属性相似


    margin

    layout_marginStart
    layout_marginEnd
    layout_marginLeft
    layout_marginTop
    layout_marginRight
    layout_marginBottom


    <!-- 以下请参考 activity_constraint_layout_two.xml -->
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


    <!-- 以下请参考 activity_constraint_layout_three.xml -->
    Ratio
    layout_constraintDimensionRatio

    宽或高至少一边设置为MATCH_CONSTRAINT（0dp）
    只有一边设置为0dp时，此时跟x,y轴的约束无关

    当不设置w/h时（2:1），均为宽：高

    当设置w/h时（w,2:1）与设置dp值的一边有关
    w:0dp
    h:100dp
    w,2:1  宽为2，高为1，宽：高
    h,2:1  宽为1/2，高为1，高：宽
    w:100dp
    h:0dp
    w,2:1  宽为1，高为2，高：宽
    h,2:1  宽为1，高位1/2，宽：高

    当两边都设置为MATCH_CONSTRAINT（0dp）时，根据是宽还是高设置约束
    x轴设置约束
    W,2:3  宽为1，高为2/3，高：宽
    H,2:3  宽为1，高为3/2，宽：高
    y轴设置约束时
    W,2:3  宽为2/3，高为1，宽：高
    H,2:3  宽为3/2，高位1，高：宽


    Chains
    chains 提供了在一个单轴（横轴或纵轴）中类似组的行为。另一轴可以独立进行约束。
    链（chains）中的相互两个组件之间，需要进行互相约束
    一个相互间双向连接的组件集合就认为是一个chain

    chain head
    即水平chain的最左边的元素，或纵向chain的最顶部元素

    Margins in chains
    如果在连接中定义了margins，chain中元素的定位就会发生变化。在Chain Style为CHAIN_SPREAD时，margins设置，会扣除已分配的空间
    (注意，android_layoutMargin和goneMargin的表现是不同的)

    Chain Style
    如果在chain head元素上设置 layout_constraintHorizontal_chainStyle或layout_constraintVertical_chainStyle ，
    chain的行为就会发生相应的变化。

    styles：
    （参考activity_constraint_layout_three的51行向下）

    CHAIN_SPREAD
    对应属性值：spread。默认样式，元素铺展开
    在当前样式下，如果一些组件设置了”match_constraint”，它们将会分割占用有效的空间

    CHAIN_SPREAD_INSIDE
    对应属性值：spread_inside。类似，spread。chain的两端元素不会被展开

    CHAIN_PACKED
    对应属性值：packed。将chain中元素包裹起来，当设置了横向或纵向的bias时，会影响其中的所有元素。

    Weighted chains
    （参考activity_constraint_layout_three第51行）
    类似LinearLayout中的android:layout_weight属性。
    使用layout_constraintHorizontal_weight或layout_constraintVertical_weight，当宽或高为MATCH_CONSTRAINT（即等于0dp）时，起作用。

![chains-styles](/img/chains-styles.png)


    <!-- 以下请参考 activity_constraint_layout_four.xml -->
    Group：ConstraintLayout的一个辅助类，不会在页面中显示，用于控制一组view的显示和隐藏
    设置宽高无效

    constraint_referenced_ids
    添加view的ID，多个用逗号隔开（id,id,id）


    GuideLine：导航线/辅助线，辅助类，不会在页面中显示
    设置宽高无效，用于给其他view提供参考的辅助线

    orientation：方向，水平或垂直
    layout_constraintGuide_percent：百分比，水平或垂直方向的百分比
    layout_constraintGuide_begin：水平或垂直方向距离父容器开始的距离的dp值
    layout_constraintGuide_end：水平或垂直方向距离父容器结束的距离的dp值


    Barrier：障碍区，辅助类，不会在页面中显示，设置宽高无效
    用于隔绝一定的区域

    barrierDirection：隔绝的方向，左上右下（left/top/right/bottom/start/end）
    constraint_referenced_ids：隔绝的views，添加view的ID，多个用逗号隔开（id,id,id）

    <!-- end -->

> UI编辑器使用的属性

    实际使用中可以不用关心这些属性
    layout_optimizationLevel
    layout_editor_absoluteX
    layout_editor_absoluteY
    layout_constraintBaseline_creator
    layout_constraintTop_creator
    layout_constraintRight_creator
    layout_constraintLeft_creator
    layout_constraintBottom_creator


> ConstraintLayout的所有属性都可以通过代码来进行设置




