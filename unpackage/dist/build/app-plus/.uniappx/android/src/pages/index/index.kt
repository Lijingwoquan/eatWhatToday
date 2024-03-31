@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.UNI7752EBC;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.extapi.getStorage as uni_getStorage;
import io.dcloud.uniapp.extapi.setStorageSync as uni_setStorageSync;
open class GenPagesIndexIndex : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onCreated(fun() {
            this.initListFromStorage();
        }
        , instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_u_todo_item = resolveEasyComponent("u-todo-item", GenComponentsUTodoItemUTodoItemClass);
        val _component_u_action = resolveEasyComponent("u-action", GenComponentsUActionUActionClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("list-view", utsMapOf("direction" to "vertical", "style" to normalizeStyle(utsMapOf("height" to "1200rpx"))), utsArrayOf(
                createElementVNode("list-item", utsMapOf("class" to "mt-5 flex justify-center flex-column align-center"), utsArrayOf(
                    if (_ctx.todoList.length != 0) {
                        createElementVNode("view", utsMapOf("key" to 0), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "text-dark font-lg p-2"), " 没吃过 ")
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                )),
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.todoList, fun(item, _, _, _): VNode {
                    return createVNode(_component_u_todo_item, utsMapOf("key" to item.id, "checked" to item.checked, "id" to item.id, "text" to item.text, "onDestory" to _ctx.deleteItemfromList, "onChecked" to _ctx.onChecked), null, 8, utsArrayOf(
                        "checked",
                        "id",
                        "text",
                        "onDestory",
                        "onChecked"
                    ));
                }
                ), 128),
                createElementVNode("list-item", utsMapOf("class" to "mt-5 flex justify-center flex-column align-center"), utsArrayOf(
                    if (_ctx.completedList.length != 0) {
                        createElementVNode("view", utsMapOf("key" to 0), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "text-dark font-lg p-2"), " 吃过 ")
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                    ,
                    if (_ctx.list.length == 0) {
                        createElementVNode("view", utsMapOf("key" to 1), utsArrayOf(
                            createElementVNode("image", utsMapOf("src" to default1)),
                            createElementVNode("text", utsMapOf("class" to "text-light-black text-center font-lg mt-2"), "没有要吃的，点击小角图片添加")
                        ));
                    } else {
                        createCommentVNode("v-if", true);
                    }
                )),
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.completedList, fun(item, _, _, _): VNode {
                    return createVNode(_component_u_todo_item, utsMapOf("key" to item.id, "checked" to item.checked, "id" to item.id, "text" to item.text, "onDestory" to _ctx.deleteItemfromList, "onChecked" to _ctx.onChecked), null, 8, utsArrayOf(
                        "checked",
                        "id",
                        "text",
                        "onDestory",
                        "onChecked"
                    ));
                }
                ), 128)
            ), 4),
            createVNode(_component_u_action, utsMapOf("list" to _ctx.todoList, "onOutput" to _ctx.appedItemToList), null, 8, utsArrayOf(
                "list",
                "onOutput"
            ))
        ), 64);
    }
    open var list: UTSArray<Item> by `$data`;
    open var todoList: UTSArray<Item> by `$data`;
    open var completedList: UTSArray<Item> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("list" to utsArrayOf<Item>(), "todoList" to computed<UTSArray<Item>>(fun(): UTSArray<Item> {
            return this.list.filter(fun(item: Item): Boolean {
                return !item.checked;
            }
            );
        }
        ), "completedList" to computed<UTSArray<Item>>(fun(): UTSArray<Item> {
            return this.list.filter(fun(item: Item): Boolean {
                return item.checked;
            }
            );
        }
        ));
    }
    override fun `$initMethods`() {
        this.appedItemToList = fun(text: String) {
            val item = Item(id = nanoid(), text = text, checked = false);
            this.list = utsArrayOf(
                item
            ).concat(this.list);
            this.updateListToStroage();
        }
        ;
        this.deleteItemfromList = fun(id: String) {
            this.list = this.list.filter(fun(item: Item): Boolean {
                return id != item.id;
            }
            );
            this.updateListToStroage();
        }
        ;
        this.onChecked = fun(payload: CheckedPayload) {
            val item = this.list.find(fun(item: Item): Boolean {
                return item.id == payload.id;
            }
            );
            item!!.checked = payload.checked;
            this.updateListToStroage();
        }
        ;
        this.updateListToStroage = fun() {
            uni_setStorageSync(storageKey, JSON.stringify(this.list));
        }
        ;
        this.initListFromStorage = fun() {
            uni_getStorage(GetStorageOptions(key = storageKey, success = fun(res: GetStorageSuccess){
                val list = JSON.parseArray<Item>(res.data as String);
                if (list != null) {
                    this.list = list;
                }
            }
            ));
        }
        ;
    }
    open lateinit var appedItemToList: (text: String) -> Unit;
    open lateinit var deleteItemfromList: (id: String) -> Unit;
    open lateinit var onChecked: (payload: CheckedPayload) -> Unit;
    open lateinit var updateListToStroage: () -> Unit;
    open lateinit var initListFromStorage: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(), utsArrayOf(
                    GenApp.styles
                ));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
