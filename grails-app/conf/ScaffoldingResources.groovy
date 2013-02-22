modules = {
	scaffolding {
        resource url:[dir:'less',file:'bootstrap.less'],attrs:[rel:"stylesheet/less",type:'css']
        resource url:[dir:'less',file:'responsive.less'],attrs:[rel:"stylesheet/less", type:'css'],disposition:'head'
        resource url:'css/scaffolding.css'
	}
}