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
open class GenComponentsUTodoItemUTodoItem : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onCreated(fun() {
            this.intenalChecked = this.checked;
        }
        , instance);
        onMounted(fun() {
            this.`$nextTick`(fun(){
                this.amplity = "animate-amplify";
            }
            );
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_switch = resolveComponent("switch");
        val _component_u_icon = resolveEasyComponent("u-icon", GenComponentsUIconUIconClass);
        return createElementVNode("list-item", utsMapOf("type" to _ctx.id, "class" to normalizeClass(utsArrayOf(
            "bg-white m-2 p-4 rounded-lg flex justify-between animate-base",
            utsArrayOf(
                _ctx.amplity,
                _ctx.fadeOut
            )
        ))), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "flex align-center"), utsArrayOf(
                createVNode(_component_switch, utsMapOf("style" to normalizeStyle(utsMapOf("transform" to "scale(0.7)")), "checked" to _ctx.intenalChecked, "onChange" to _ctx.onSwitchChange), null, 8, utsArrayOf(
                    "style",
                    "checked",
                    "onChange"
                )),
                createElementVNode("text", utsMapOf("class" to "font-lg ml-1"), toDisplayString(_ctx.text), 1)
            )),
            createVNode(_component_u_icon, utsMapOf("code" to "\ue613", "color" to "gray", "onClick" to _ctx.destory), null, 8, utsArrayOf(
                "onClick"
            ))
        ), 10, utsArrayOf(
            "type"
        ));
    }
    open var id: String by `$props`;
    open var text: String by `$props`;
    open var checked: Boolean by `$props`;
    open var amplity: String by `$data`;
    open var intenalChecked: Boolean by `$data`;
    open var fadeOut: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("amplity" to "", "intenalChecked" to false, "fadeOut" to computed<String>(fun(): String {
            return if (this.intenalChecked) {
                "animate-fade-out";
            } else {
                "";
            }
            ;
        }
        ));
    }
    override fun `$initMethods`() {
        this.destory = fun() {
            this.`$emit`("destory", this.id);
        }
        ;
        this.onSwitchChange = fun(e: SwitchChangeEvent) {
            val payload = CheckedPayload(id = this.id, checked = e.detail.value);
            this.intenalChecked = payload.checked;
            this.`$emit`("checked", payload);
        }
        ;
    }
    open lateinit var destory: () -> Unit;
    open lateinit var onSwitchChange: (e: SwitchChangeEvent) -> Unit;
    companion object {
        var name = "u-todo-item";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("animate-base" to padStyleMapOf(utsMapOf("transform" to "scale(0.4)", "transitionProperty" to "transform", "transitionDuration" to "0.3s")), "animate-amplify" to padStyleMapOf(utsMapOf("transform" to "scale(1)", "transitionProperty" to "transform", "transitionDuration" to "0.3s")), "animate-fade-out" to padStyleMapOf(utsMapOf("opacity" to 0.3)), "@TRANSITION" to utsMapOf("animate-base" to utsMapOf("property" to "transform", "duration" to "0.3s"), "animate-amplify" to utsMapOf("property" to "transform", "duration" to "0.3s")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf("destory" to null, "checked" to null);
        var props = normalizePropsOptions(utsMapOf("id" to utsMapOf("type" to "String", "required" to true), "text" to utsMapOf("type" to "String", "required" to true), "checked" to utsMapOf("type" to "Boolean", "required" to true)));
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
