<template>
  <div>
      <el-header style="text-align: center; font-size: 25px">
        <el-dropdown>
          <span></span>
          <i class="el-icon-setting" style="margin-right: 30px"></i>
        </el-dropdown>
        <span style="text-align: center">Welcome to SeaHorse</span>
      </el-header>
    <el-container style="height: 900px; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
        <el-menu
          style="width: 100%"
          default-active="$route.path"
          router="true"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose">

          <el-submenu index="1">
            <template slot="title"><i class="el-icon-menu"></i>商品管理</template>
            <el-menu-item-group>
              <el-menu-item index="/components/cargo">商品信息</el-menu-item>
              <el-menu-item index="/components/shelves">货架信息</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>商家管理</template>
            <el-menu-item-group>
              <el-menu-item index="/components/dealer">商家信息</el-menu-item>
              <el-menu-item index="/components/market">商场信息</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="3">
            <template slot="title"><i class="el-icon-menu"></i>仓储管理</template>
            <el-menu-item-group>
              <el-menu-item index="/components/goods">货物信息</el-menu-item>
              <el-menu-item index="/components/management">仓库信息</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="4">
            <template slot="title"><i class="el-icon-menu"></i>统计管理</template>
            <el-menu-item-group>
              <el-menu-item index="/components/activities">商家活动</el-menu-item>
              <el-menu-item index="/components/shop">商家统计</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="5">
            <template slot="title"><i class="el-icon-menu"></i>订单管理</template>
            <el-menu-item-group>
              <el-menu-item index="/components/orders">订单信息</el-menu-item>
              <el-menu-item index="/components/user">用户信息</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="6">
            <template slot="title"><i class="el-icon-menu"></i>配送管理</template>
            <el-menu-item-group>
              <el-menu-item index="/components/deliveryclerk">配送员信息</el-menu-item>
              <el-menu-item index="/components/order">订单号</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="7">
            <template slot="title"><i class="el-icon-menu"></i>评价管理</template>
            <el-menu-item-group>
              <el-menu-item index="merchant">商家评价</el-menu-item>
              <el-menu-item index="trade">商品评价</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

          <el-submenu index="8">
            <template slot="title"><i class="el-icon-menu"></i>监督管理</template>
            <el-menu-item-group>
              <el-menu-item index="appraise">监督员信息</el-menu-item>
              <el-menu-item index="business">监督联盟信息</el-menu-item>
            </el-menu-item-group>
          </el-submenu>

        </el-menu>
      </el-aside>

      <el-main>
          <router-view></router-view>
      </el-main>

    </el-container>

  </div>
</template>

<script>
export default {
  name: 'App',
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style>
.el-header {
  background-color:#606266;
  color: #909399;
  line-height: 20px;
}

.el-aside {
  color: #333;
}
</style>
