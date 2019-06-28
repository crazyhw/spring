<template>
  <div>

    <el-table :data="tableData">
      <el-table-column  label="活动编号" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.num }}</span>
        </template>
      </el-table-column>
      <el-table-column  label="活动类型" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.type }}</span>
        </template>
      </el-table-column>
      <el-table-column  label="活动内容" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.content }}</span>
        </template>
      </el-table-column>
      <el-table-column  label="活动持续时间" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.date }}</span>
        </template>
      </el-table-column>
      <el-table-column  label="店铺名" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.shop.name }}</span>
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

          <el-dialog title="添加活动" :visible.sync="dialogFormVisible">
            <el-form :model="Form">
              <el-form-item label="活动编号" :label-width="formLabelWidth">
                <el-input v-model="Form.num" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="活动类型" :label-width="formLabelWidth">
                <el-input v-model="Form.type" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="活动内容" :label-width="formLabelWidth">
                <el-input v-model="Form.content" autocomplete="off">
                </el-input>
              </el-form-item>
              <el-form-item label="活动持续时间" :label-width="formLabelWidth">
                <el-input v-model="Form.date" autocomplete="off">
                </el-input>
              </el-form-item>
              <el-form-item label="店铺名" :label-width="formLabelWidth">
                <el-input v-model="Form.shop.name" autocomplete="off">
                </el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="postForm" id="submit" onclick="">确 定</el-button>
            </div>
          </el-dialog>


          <el-dialog title="修改活动信息" :visible.sync="dialogUpdateVisible">
            <el-form :model="Form">
              <el-form-item label="活动编号" :label-width="formLabelWidth">
                <el-input v-model="Form.num" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="活动类型" :label-width="formLabelWidth">
                <el-input v-model="Form.type" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="活动内容" :label-width="formLabelWidth">
                <el-input v-model="Form.content" autocomplete="off">
                </el-input>
              </el-form-item>
              <el-form-item label="活动持续时间" :label-width="formLabelWidth">
                <el-input v-model="Form.date" autocomplete="off">
                </el-input>
              </el-form-item>
              <el-form-item label="店铺名" :label-width="formLabelWidth">
                <el-input v-model="Form.shop.name" autocomplete="off">
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
          type: '',
          content: '',
          date: '',
          shop: {},
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
        s.name=Form.shop.name;
        params.id=Form.id;
        params.num=Form.num;
        params.type=Form.type;
        params.content=Form.content;
        params.date=Form.date;
        params.shop=s;

        console.log(params);

        this.$axios({
          method: "post",
          url: 'activities/updateActivities/',
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
        const url = 'activities/addActivities/';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('num', this.Form.num);
        params.append('type', this.Form.type);
        params.append('content', this.Form.content);
        params.append('date', this.Form.date);
        params.append('shop.name', this.Form.shop.name);

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
          .delete('activities/deleteActivities/' + expenditureId)
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
      this.$axios.get('activities/all')
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
