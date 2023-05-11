<template>
  <div>
      <h1>当前证型标注</h1>
      <br>
      <Picture></Picture>
      <br>
      <ClusterList></ClusterList>
  </div>
</template>


<script>
import ClusterList from './List'
import Picture from './Picture'
export default {


components: {
    ClusterList,
    Picture
}
}
</script>

<style>

</style>