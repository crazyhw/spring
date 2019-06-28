<template>
  <div>

    <el-table :data="tableData">
      <el-table-column  label="监督员编号" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.number }}</span>
        </template>
      </el-table-column>
      <el-table-column  label="监督员姓名" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column  label="监督员联系方式" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.evaluate }}</span>
        </template>
      </el-table-column>
      <el-table-column  label="监督员所在监督队" width="140">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.business.name }}</span>
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

          <el-dialog title="添加监督员" :visible.sync="dialogFormVisible">
            <el-form :model="Form">
              <el-form-item label="监督员编号" :label-width="formLabelWidth">
                <el-input v-model="Form.number" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="监督员姓名" :label-width="formLabelWidth">
                <el-input v-model="Form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="监督员联系方式" :label-width="formLabelWidth">
                <el-input v-model="Form.evaluate" autocomplete="off">
                </el-input>
              </el-form-item>
              <el-form-item label="监督员所在监督队" :label-width="formLabelWidth">
                <el-input v-model="Form.business.name" autocomplete="off">
                </el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="dialogFormVisible = false">取 消</el-button>
              <el-button type="primary" @click="postForm" id="submit" onclick="">确 定</el-button>
            </div>
          </el-dialog>


          <el-dialog title="修改监督员信息" :visible.sync="dialogUpdateVisible">
            <el-form :model="Form">
              <el-form-item label="监督员编号" :label-width="formLabelWidth">
                <el-input v-model="Form.number" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="监督员姓名" :label-width="formLabelWidth">
                <el-input v-model="Form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="监督员联系方式" :label-width="formLabelWidth">
                <el-input v-model="Form.evaluate" autocomplete="off">
                </el-input>
              </el-form-item>
              <el-form-item label="监督员所在监督队" :label-width="formLabelWidth">
                <el-input v-model="Form.business.name" autocomplete="off">
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
          number: '',
          name: '',
          evaluate: '',
          business: {},
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
        s.name=Form.business.name;
        params.id=Form.id;
        params.number=Form.number;
        params.name=Form.name;
        params.evaluate=Form.evaluate;
        params.business=s;

        console.log(params);

        this.$axios({
          method: "post",
          url: 'appraise/updateAppraise/',
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
        const url = 'appraise/addAppraise/';
        this.dialogFormVisible = false;

        var params = new URLSearchParams();
        params.append('number', this.Form.number);
        params.append('name', this.Form.name);
        params.append('evaluate', this.Form.evaluate);
        params.append('business.name', this.Form.business.name);

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
          .delete('appraise/deleteAppraise/' + expenditureId)
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
      this.$axios.get('appraise/all')
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
