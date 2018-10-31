<fieldset class="layui-elem-field layui-field-title">
  <legend>问卷信息</legend>
</fieldset>
<input type="hidden" name="quesSurveyId" value="${quesSurvey.quesSurveyId!}"/>
<div class="layui-form-item">
    <label class="layui-form-label">问卷名称</label>

    <div class="layui-input-block">
        <input type="text" name="quesSurveyName" autocomplete="off" placeholder="请输入问卷名称" lay-verify="required"
               class="layui-input" value="${quesSurvey.quesSurveyName!}">
    </div>
</div>
<div class="layui-form-item">
    <div class="layui-inline">
        <label class="layui-form-label">日期选择</label>

        <div class="layui-input-inline">
            <input type="text" name="startDate" id="startDate" autocomplete="off" class="layui-input" placeholder="开始时间" value="${quesSurvey.startDate!}">
        </div>
        <div class="layui-input-inline">
            <input type="text" name="endDate" id="endDate" autocomplete="off" class="layui-input" placeholder="结束时间" value="${quesSurvey.endDate!}">
        </div>
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">问卷LOGO</label>

    <div class="layui-input-block">
        <input type="text" name="quesSurveyLogoUrl" autocomplete="off" placeholder="请输入问卷LOGO链接" lay-verify="required"
               class="layui-input" value="${quesSurvey.quesSurveyLogoUrl!}">
    </div>
</div>

<div class="layui-form-item layui-form-text">
    <label class="layui-form-label">问卷说明</label>
    <div class="layui-input-block">
        <textarea id="LAY_demo_editor" placeholder="请输入问卷说明" name="quesSurveyRemarks" class="layui-textarea" lay-verify="content">${quesSurvey.quesSurveyRemarks!}</textarea>
    </div>
</div>
  
