<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jian/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/jian/jquery/jquery-1.9.1.min.js"></script>
   <script src="/jian/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<a id="modal-851585" href="#modal-container-851585" role="button" class="btn" data-toggle="modal">触发遮罩窗体</a>
			<div id="modal-container-851585" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="fasle">×</button>
					<h3 id="myModalLabel">
						标题栏
					</h3>
				</div>
				<div class="modal-body">
					<p>
						显示信息
					</p>
				</div>
				<div class="modal-footer">
					 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> <button class="btn btn-primary">保存设置</button>
				</div>
			</div>
			<!-- <div class="carousel slide" id="carousel-548174">
				<ol class="carousel-indicators">
					<li data-slide-to="0" data-target="#carousel-548174">
					</li>
					<li data-slide-to="1" data-target="#carousel-548174">
					</li>
					<li data-slide-to="2" data-target="#carousel-548174">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active left">
						<img alt="" src="images/add_range_icon.jpg" />
						<div class="carousel-caption">
							<h4>
								棒球
							</h4>
							<p>
								棒球运动是一种以棒打球为主要特点，集体性、对抗性很强的球类运动项目，在美国、日本尤为盛行。
							</p>
						</div>
					</div>
					<div class="item next left">
						<img alt="" src="images/meitunlogo.jpg" />
						<div class="carousel-caption">
							<h4>
								冲浪
							</h4>
							<p>
								冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。
							</p>
						</div>
					</div>
					<div class="item">
						<img alt="" src="images/sub_btn.jpg" />
						<div class="carousel-caption">
							<h4>
								自行车
							</h4>
							<p>
								以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。
							</p>
						</div>
					</div>
				</div> <a data-slide="prev" href="#carousel-548174" class="left carousel-control">‹</a> <a data-slide="next" href="#carousel-548174" class="right carousel-control">›</a>
			</div> -->
			<form class="form-search">
				<input class="input-medium search-query" type="text" /> <button type="submit" class="btn">查找</button>
			</form>
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							产品
						</th>
						<th>
							交付时间
						</th>
						<th>
							状态
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr class="success">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
					</tr>
					<tr class="error">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
				</tbody>
			</table>
			<div class="pagination">
				<ul>
					<li>
						<a href="#">上一页</a>
					</li>
					<li>
						<a href="#">1</a>
					</li>
					<li>
						<a href="#">2</a>
					</li>
					<li>
						<a href="#">3</a>
					</li>
					<li>
						<a href="#">4</a>
					</li>
					<li>
						<a href="#">5</a>
					</li>
					<li>
						<a href="#">下一页</a>
					</li>
				</ul>
			</div>
			<div class="alert alert-success" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Warning!</strong> Better check yourself, you're not looking too good.</div>
			<div class="alert alert-info" role="alert">...</div>
			<div class="alert alert-warning" role="alert">...</div>
			<div class="alert alert-danger" role="alert">...</div>
			<div class="alert">
				 <button type="button" class="close" data-dismiss="alert">×</button>
				<h4>
					提示!
				</h4> <strong>警告!</strong> 请注意你的个人隐私安全.
			</div>
		</div>
	</div>
</div>
</body>

<style>
li {list-style-type:none;float:left}
.pagination ul > li > a, .pagination ul > li > span {
    -moz-border-bottom-colors: none;
    -moz-border-left-colors: none;
    -moz-border-right-colors: none;
    -moz-border-top-colors: none;
    background-color: #ffffff;
    border-color: #dddddd;
    border-image: none;
    border-style: solid;
    border-width: 1px 1px 1px 0;
    float: left;
    line-height: 20px;
    padding: 4px 12px;
    text-decoration: none;
}
</style>
</html>