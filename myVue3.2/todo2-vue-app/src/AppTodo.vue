<template>
    <div id="app" class="container">
      <div class="card card-body bg-light">
        <div class="title">todoList데이터를 AppTodo.vue(루트컴포넌트)에 두는 경우</div>
      </div>
      <div class="card card-default card-borderless">
        <div class="card-body">
          <InputTodo @add="addTodo" />
          <TodoList :todoList="todoList" @delete-todo="deleteTodo" @toggle-completed="toggleCompleted" />
        </div>
      </div>
    </div>
  </template>
  
  <script>
    //npm install axios설치후 임포트합니다
// import axios from 'axios';
    import TodoList from './components/TodoList.vue'
    import InputTodo from './components/TodoInput.vue'

  
    export default {
      name: "App",
      components : { InputTodo, TodoList },     
      data() {
        return {
          todoList : [
          {id:1, todo: '내용1', completed: false},
          {id:2, todo: '내용2', completed: true},
          {id:3, todo: '내용3', completed: false}
          ]
        }
      },
      methods: {
        addTodo(e) {
          console.log(e.todo)
          const ids = this.todoList.map(todo=> {return todo.id})
          const maxId = ids.length == 0? 0 : Math.max(...ids)
          this.todoList.push({id:maxId+1, todo: e.todo, completed: false})
        },
        deleteTodo(id) {
          let index = this.todoList.findIndex((item) => id === item.id);
          this.todoList.splice(index, 1);
        },
        toggleCompleted(id) {
          let index = this.todoList.findIndex((item) => id === item.id);
          this.todoList[index].completed = !this.todoList[index].completed;
        }
      }
    }
  </script>
  <style scoped>
  @import "https://unpkg.com/bootstrap@5.2.3/dist/css/bootstrap.min.css";
body { margin: 0; padding: 0; font-family: sans-serif; }
.title { text-align: center; font-weight:bold; font-size:20pt; }

.container { padding:10px 10px 10px 10px; }


.card-borderless { border: 0; box-shadow: none; }
</style>