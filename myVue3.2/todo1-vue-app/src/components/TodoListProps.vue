<template>
    <div class="row">
        <div class="col">
            <hr>
            <ul class="list-group">
                <TodoListItem v-for="todoItem in todoList" :key="todoItem.id" :todoItem="todoItem" @deleted="deletedTodo"
                    @toggleCompleted="toggleCompleted" />
            </ul>            
        </div>
    </div>
</template>
<script>
import TodoListItem from './TodoListItem.vue';
export default {
    name: 'todoList',
    components: { TodoListItem },
    data() {
        return {
            todoList: //목록과 바인드될 프로퍼티 
                [{ id: 1, todo: '내용1', completed: false },
                { id: 2, todo: '내용2', completed: true },
                { id: 3, todo: '내용3', completed: false },
                ]
                ,    
        }
    },    
    props: ["todo"],
    
    
    methods: {
        addTodo() {
            const ids = this.todoList.map(todo => { return todo.id })
            const maxId = ids.length == 0 ? 0 : Math.max(...ids)
            this.todoList.push({ id: maxId + 1, todo: this.todo, completed: false })       
            
        },
        deletedTodo(id) {
            let index = this.todoList.findIndex((item) => id === item.id);
            this.todoList.splice(index, 1);
        },
        toggleCompleted(id) {
            this.status = 'toggleCompleted'
            let index = this.todoList.findIndex((item) => id === item.id);
            this.todoList[index].completed = !this.todoList[index].completed;
        }
    },
    watch : {
		// todo() {        
        //         this.addTodo(newTodo)
        // },
        todo: {
            handler: function (current) {
                console.log("todo데이터가 변경되었습니다")
                this.addTodo(current)
            }
        },
        todoList:{ //배열데이터는 참조형이다, 배열참조메모리가 변하지 않으면 감지 못함
            deep: true, // 배열요소변화까지 감지가능, 객체내용변화 감지가능
            handler(current, old) {      
                console.log(current)   
            }
        }
    }
}
</script>
<style lang="">    
</style>