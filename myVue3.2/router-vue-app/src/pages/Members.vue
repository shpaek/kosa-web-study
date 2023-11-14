<template>
    <div class="card card-body">
        <h2>Members</h2>
        <div v-for="m in members">
          <a :href="'./members/'+m.id">{{ m.name }}</a>
        </div>
    </div>
</template>

<script>
export default {
  name : "Members",
  data(){
    return  {
      members:[{id:1,name:'알라딘'},{id:2, name:'자스민'},{id:3, name:'지니'}]
    }
  }
}
</script>