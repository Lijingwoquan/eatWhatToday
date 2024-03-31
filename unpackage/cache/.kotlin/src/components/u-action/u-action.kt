@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.HBuilder;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.unicloud.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
open class GenComponentsUActionUAction : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        this.`$watch`(fun(): Any? {
            return this.panelVisiable;
        }
        , fun(v: Boolean) {
            this.panelFous = v;
        }
        );
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_u_icon = resolveEasyComponent("u-icon", GenComponentsUIconUIconClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            if (isTrue(!_ctx.panelVisiable)) {
                createElementVNode("view", utsMapOf("key" to 0), utsArrayOf(
                    createVNode(_component_u_icon, utsMapOf("class" to "plus-btn-right rounded-circle position-fixed", "size" to "60rpx", "code" to "\ue657", "onClick" to fun(){
                        _ctx.panelVisiable = true;
                    }), null, 8, utsArrayOf(
                        "onClick"
                    )),
                    createVNode(_component_u_icon, utsMapOf("class" to "plus-btn-left rounded-circle position-fixed", "size" to "60rpx", "code" to "\ue750", "onClick" to _ctx.getRandomDish), null, 8, utsArrayOf(
                        "onClick"
                    ))
                ));
            } else {
                createElementVNode("view", utsMapOf("key" to 1, "class" to "panel position-fixed bottom-0 p-2 justify-center", "style" to normalizeStyle(utsMapOf("bottom" to """${_ctx.panelBottom}px"""))), utsArrayOf(
                    createElementVNode("input", utsMapOf("placeholder" to "添加菜品", "focus" to _ctx.panelFous, "adjust-position" to false, "onKeyboardheightchange" to _ctx.onKeyboardheightchange, "onConfirm" to _ctx.onInputConfirm), null, 40, utsArrayOf(
                        "focus",
                        "onKeyboardheightchange",
                        "onConfirm"
                    ))
                ), 4);
            }
            ,
            if (isTrue(_ctx.hasGetRandomDish)) {
                createElementVNode("view", utsMapOf("key" to 2, "class" to normalizeClass(utsArrayOf(
                    "showDish animate-base rounded-circle justify-center align-center p-4 m-4 position-fixed",
                    utsArrayOf(
                        _ctx.amplity
                    )
                ))), utsArrayOf(
                    createElementVNode("text", null, toDisplayString(_ctx.dishName), 1)
                ), 2);
            } else {
                createCommentVNode("v-if", true);
            }
        ), 64);
    }
    open var list: UTSArray<Any?> by `$props`;
    open var panelBottom: Number by `$data`;
    open var panelVisiable: Boolean by `$data`;
    open var panelFous: Boolean by `$data`;
    open var amplity: String by `$data`;
    open var hasGetRandomDish: Boolean by `$data`;
    open var dishName: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("panelBottom" to 0, "panelVisiable" to false, "panelFous" to false, "amplity" to "", "hasGetRandomDish" to false, "dishName" to "");
    }
    override fun `$initMethods`() {
        this.onInputConfirm = fun(e: InputConfirmEvent) {
            val text = e.detail.value;
            val isEmpty = text.length == 0 || text.trim() == "";
            if (isEmpty) {
                return;
            }
            this.`$emit`("output", text);
        }
        ;
        this.onKeyboardheightchange = fun(e: InputKeyboardHeightChangeEvent) {
            if (e.detail.height <= 0) {
                this.panelVisiable = false;
            }
            this.panelBottom = if (e.detail.height > 0) {
                340;
            } else {
                0;
            }
            ;
        }
        ;
        this.getRandomDish = fun() {
            if (!this.hasGetRandomDish) {
                this.hasGetRandomDish = true;
                this.`$nextTick`(fun(){
                    this.amplity = "animate-amplify";
                });
                val item = this.list[Math.round(Math.random() * (this.list.length - 1))] as Item;
                if (item.text != "") {
                    this.dishName = item.text;
                }
            } else {
                this.amplity = "animate-fade-out";
            }
        }
        ;
    }
    open lateinit var onInputConfirm: (e: InputConfirmEvent) -> Unit;
    open lateinit var onKeyboardheightchange: (e: InputKeyboardHeightChangeEvent) -> Unit;
    open lateinit var getRandomDish: () -> Unit;
    companion object {
        var name = "u-action";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("plus-btn-right" to padStyleMapOf(utsMapOf("width" to "80rpx", "height" to "80rpx", "right" to "25rpx", "bottom" to "50rpx")), "showDish" to padStyleMapOf(utsMapOf("bottom" to "15rpx", "width" to "500rpx", "right" to "80rpx", "left" to "80rpx", "backgroundColor" to "#fd717f")), "plus-btn-left" to padStyleMapOf(utsMapOf("width" to "80rpx", "height" to "80rpx", "left" to "25rpx", "bottom" to "50rpx")), "panel" to padStyleMapOf(utsMapOf("width" to "100%", "height" to "100rpx", "backgroundColor" to "#fb3b88")), "animate-base" to padStyleMapOf(utsMapOf("transform" to "scale(0.4)", "transitionProperty" to "transform", "transitionDuration" to "0.3s")), "animate-amplify" to padStyleMapOf(utsMapOf("transform" to "scale(0.8)", "transitionProperty" to "transform", "transitionDuration" to "0.3s")), "animate-fade-out" to padStyleMapOf(utsMapOf("transform" to "scale(0.8)", "opacity" to 0.3)), "@TRANSITION" to utsMapOf("animate-base" to utsMapOf("property" to "transform", "duration" to "0.3s"), "animate-amplify" to utsMapOf("property" to "transform", "duration" to "0.3s")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("output" to null);
        var props = normalizePropsOptions(utsMapOf("list" to utsMapOf("type" to "Array", "required" to true)));
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
