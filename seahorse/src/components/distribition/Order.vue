<template>
  <div>

    <el-table :data="tableData">
      <el-table-column  label="订单编号" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.num }}</span>
        </template>
      </el-table-column>
      <el-table-column  label="商家" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column  label="配送员" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.deliveryclerk.name }}</span>
        </template>
      </el-table-column>

      <el-table-column  label="操作" >
        <template slot-scope="scope">
          <el-button
            type="success"
            size="mini" round
            @click="up(scope.$index, scope.row)">修改</el-button>

          <el-button
            size="mini"
            type="danger" round
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>

          <el-dialog title="添加订单" :visible.sync="dialogFormVisible">
            <el-form :model="Form">
              <el-form-item label="订单编号" :label-width="formLabelWidth">
                <el-input v-model="Form.num" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="商家" :label-width="formLabelWidth">
                <el-input v-model="Form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="配送员" :label-width="formLabelWidth">
                <el-input v-model="Form.deliveryclerk.name" autocomplete="off">
                </el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="postForm" id="submit" onclick="">确 定</el-button>
            </div>
          </el-dialog>


          <el-dialog title="修改订单信息" :visible.sync="dialogUpdateVisible">
            <el-form :model="Form">
              <el-form-item label="订单编号" :label-width="formLabelWidth">
                <el-input v-model="Form.num" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="商家" :label-width="formLabelWidth">
                <el-input v-model="Form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="配送员" :label-width="formLabelWidth">
                <el-input v-model="Form.deliveryclerk.name" autocomplete="off">
                </el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogUpdateVisible = false">取 消</el-button>
              <el-button type="primary" @click="update(Form)" >确 定</el-button>
            </div>
          </el-dialog>

        </template>
      </el-table-column>

    </el-table>
    <div>
      <el-button
        type="info" round
        @click="dialogFormVisible = true">添加</el-button>
    </div>
  </div>
</template>

<script>

  export default {
    data() {
      return {
        tableData: [],
        dialogTableVisible: false,
        dialogFormVisible: false,
        dialogUpdateVisible:false,
        Form: {
          id:'',
          num: '',
          name: '',
          deliveryclerk: {},
        },
        formLabelWidth: '100px',
      }
    },


    methods: {
      search(){},
      up(index,row){
        this.dialogUpdateVisible=true;
        this.Form=Object.assign({},row);
        console.log(this.Form);
      },

      update(Form) {
        var params = {};
        var s={};
        s.name=Form.deliveryclerk.name;
        params.id=Form.id;
        params.num=Form.num;
        params.name=Form.name;
        params.deliveryclerk=s;

        console.log(params);

        this.$axios({
          method: "post",
          url: 'order/updateOrder/',
          data:params,
        })
          .then(function (response) {

            console.log(response);
            location.reload();
          })

          .catch(function (error) {

            console.log(error);

          });

      },

      postForm() {
        const url = 'order/addOrder/';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('num', this.Form.num);
        params.append('name', this.Form.name);
        params.append('deliveryclerk.name', this.Form.deliveryclerk.name);

        console.log(params);
        this.$axios({
          method: 'post',
          url: url,
          data: params,
        })

          .then(function (response) {
            console.log(response);
            location.reload();
          })

          .catch(function (error) {

            console.log(error);

          });
      },


      handleDelete(index, row) {
        console.log(index, row);
        var expenditureId = row.id;
        console.log(expenditureId);
        this.$axios
          .delete('order/deleteOrder/' + expenditureId)
          .then(res => {
            console.log(res);
            this.tableData.splice(index, 1)
          })
          .catch(err => {
            console.log(err);
          });
      },


    },
    created() {
      this.$axios.get('order/all')
        .then(response=>{

          console.log(response);

          this.tableData=response.data;

        })
        .catch(error=>{

          console.log(error);

          alert('无法访问数据');

        })

    }
  }
</script>

<style scoped>

</style>

