/**
 * http://usejsdoc.org/
 */

$(document).ready(function(){
	function clearLoginDiv() {
		$('#unameError').empty();
		$('#upwdErr').empty();
		$('#loginErr').empty();
		$('#unameError').hide();
		$('#upwdErr').hide();
		$('#loginErr').hide();
		$('#uname').val('');
		$('#upassword').val('');
		$('#loginErr').val('');
	}
	function clearRegistrationDiv() {
		$('#usernameError').empty();
		$('#pwdErr').empty();
		$('#emailErr').empty();
		$('#phnErr').empty();
		$('#usernameError').hide();
		$('#pwdErr').hide();
		$('#phnErr').hide();
		$('#emailErr').hide();
		$('#name').val('');
		$('#password').val('');
		$('#phonenumber').val('');
		$('#email').val('');
	}
	
	function clearCreatePostDiv() {
		$('#postTitleError').empty();
		$('#postArticleError').empty();
		$('#tagPostError').empty();
		$('#postTitleError').hide();
		$('#postArticleError').hide();
		$('#tagPostError').hide();
		$('#postTitle').val('');
		$('#postArticle').val('');
		$('#tagPost').val('');
	}
	$('#tableListPosts').on('click', 'td', function() { // td not tr
		var cellData = $(this).text();
		$('.div-list-posts').hide();
		$('.div-show-post').html(cellData);
		$('.div-show-post').show();
	});
	
	$('#newposthrf').click(function() {
		$('.div-list-posts').hide();
		$('.div-show-post').hide();
		$('.div-create-post').show();
	});
	
	$('#postshrf').click(function() {
		var cookieUserName = document.cookie.split('=')[1];
		if(typeof(cookieUserName) != "undefined" && cookieUserName != null){
			$.ajax({
				url : 'http://localhost:8080/stack-flood/online/user/'+cookieUserName,
				type : 'get',
				contentType : 'application/json',
				accept : 'application/json',
				success : function(response) {
					$('#tableListPosts').empty();
					if(typeof(response) != "undefined" && response != null && response != ''){
						//$('.div-blog-user-details').html('Username : '+response.userName+', Email: '+response.email+', Phone number: '+response.phoneNumber);
						clearLoginDiv();
						clearRegistrationDiv();
						$('.login-div').hide();
						$('.register-div').hide();
						$('.login-page').hide();
						$('body').css('margin','0px');
						$('.div-create-post').hide();
						$('.div-show-post').hide();
						var users = [{
						'id' : '1',
						'view' : '0',
						'reply' : '0',
						'title' : 'Title Prasanna Title Prasanna Title Prasanna Title Prasanna Title Prasanna',
						'tags' : 'tags',
						'user' : 'Prasanna Ramakrishna',
						'date' : 'Thu Jan 19 2017 19:12:21'
						},
						{
						'id' : '2',
						'view' : '1',
						'reply' : '1',
						'title' : 'Title Shruthi Title Shruthi Title Shruthi Title Shruthi',
						'tags' : 'tags',
						'user' : 'Shruthi Praanna',
						'date' : 'Thu Jan 19 2017 19:12:21'
						}];
						window.users = users;
						var i=0;
						var table = $('#tableListPosts');
						users.forEach(function(user) {
							  var tr = $('<tr>');
							  var tagList = user.tags.split(',');
							  var j=0;
							  var anchorDt='';
							  tagList.forEach(function(tag){
								  anchorDt = anchorDt + '<a id="tags-'+i+j+'">'+tag.trim()+'</a>';
								  j=j+1;
							  });
							  anchorDt.trim();
							  tr.append('<div id="data-'+i+'"><div id="view-'+i+'"><div id="viewc-'+i+'">'+user.view+'</div><div id="viewt-'+i+'">views</div></div><div id="reply-'+i+'"><div id="replyc-'+i+'">'+user.reply+'</div><div id="replyt-'+i+'">replies</div></div><div id="content-'+i+'"><div id="header-'+i+'">'+user.title+'<span style="display:none">'+user.id+'</span></div><div id="footer-'+i+'"><div id="tagd-'+i+'">'+anchorDt+'</div><div id="footerright-'+i+'"><div id="date-'+i+'">'+user.date+'</div><div id="untdet-'+i+'">'+user.user+'</div></div></div></div></div>');
							  table.append(tr);
							  i=i+1;
						});
						$('.div-list-posts').show();
					}else{
						$('#tableListPosts').empty();
						$('.div-list-posts').hide();
						$('.div-create-post').hide();
						$('.div-show-post').hide();
						$('.div-blog-posts').hide();
						clearRegistrationDiv();
						$('.register-div').hide();
						clearLoginDiv();
						$('.login-div').show();
						$('.login-page').show();
					}
				},
				error : function(error) {
					console.log('Error: '+error);
				}
			});
		}else{
			$('#tableListPosts').empty();
			$('.div-list-posts').hide();
			clearCreatePostDiv();
			$('.div-create-post').hide();
			$('.div-show-post').hide();
			$('.div-blog-posts').hide();
			clearRegistrationDiv();
			$('.register-div').hide();
			clearLoginDiv();
			$('.login-div').show();
			$('.login-page').show();
		}
	});
	
	$('#postCancelBtn').click(function() {
		$('#postTitle').val('');
		$('#postArticle').val('')
		$('#tagPost').val('');
	});
	
	$('#postBtn').click(function() {
		var cookieUserName = document.cookie.split('=')[1];
		if(typeof(cookieUserName) != "undefined" && cookieUserName != null){
			var title = $('#postTitle').val();
			var article = $('#postArticle').val();
			var createdBY = cookieUserName;
			var tags = $('#tagPost').val();
			
			if(!title || title == ''){
				$('#postTitleError').html('Please enter title.').addClass('error-msg');
				$('#postTitleError').css('margin-bottom','10px');
				$('#postTitleError').show();
			}
			if(!article || article == ''){
				$('#postArticleError').html('Please add details.').addClass('error-msg');
				$('#postArticleError').css('margin-bottom','10px');
				$('#postArticleError').show();
			}
			if(!tags || tags == ''){
				$('#tagPostError').html('Please add tags.').addClass('error-msg');
				$('#tagPostError').css('margin-bottom','10px');
				$('#tagPostError').show();
			}
			
			if(title && article && tags){
				var data = {
						title : title,
						article : article,
						tags : tags,
						createdBY : cookieUserName
					};
				$.ajax({
					url : 'http://localhost:8080/stack-flood/online/post/',
					type : 'post',
					accept : 'application/json',
					contentType : 'application/json',
					data : JSON.stringify(data),
					success : function(response) {
						clearCreatePostDiv();
						$('.div-create-post').hide();
						$('.div-show-post-title').html(response.title);
						$('.div-show-post-article').html(response.article);
						var tagList = response.tags.split(',');
						var j=0;
						var anchorDt='';
						tagList.forEach(function(tag){
							anchorDt = anchorDt + '<a id="crdtags-'+j+'">'+tag.trim()+'</a>';
							j=j+1;
						});
						$('.div-show-post-tags').html(anchorDt);
						$('.div-show-post-created-date').html(new Date(response.createdDate).toString().split('G')[0].trim());
						$('.div-show-post-createdby').html(response.createdBY);
						$('.div-show-post').show();
					},
					error : function(error) {
						console.log('Error: '+error);
					}
				});
			}
		}else{
			$('#tableListPosts').empty();
			$('.div-list-posts').hide();
			clearCreatePostDiv();
			$('.div-create-post').hide();
			$('.div-show-post').hide();
			$('.div-blog-posts').hide();
			clearRegistrationDiv();
			$('.register-div').hide();
			clearLoginDiv();
			$('.login-div').show();
			$('.login-page').show();
		}
	});
	
	$(document).on('click', '[id^="header-"]', function() {
	  console.log($(this).prop('id'));
	  console.log($('#'+$(this).prop('id')+' span').text());
	});
	
	$('#logouthrf').click(function() {
		var cookieUserName = document.cookie.split('=')[1];
		if(typeof(cookieUserName) != "undefined" && cookieUserName != null){
			$.ajax({
				url : 'http://localhost:8080/stack-flood/online/user/logout/'+cookieUserName,
				type : 'get',
				accept : 'application/json',
				contentType : 'application/json',
				success : function(response) {
					window.users=null;
					$('#tableListPosts').empty();
					$('.div-list-posts').hide();
					clearCreatePostDiv();
					$('.div-create-post').hide();
					$('.div-show-post').hide();
					$('.div-blog-posts').hide();
					clearRegistrationDiv();
					$('.register-div').hide();
					clearLoginDiv();
					$('.login-div').show();
					$('.login-page').show();
				},
				error : function(error) {
					console.log('Error: '+error);
				}
			});
		}else{
			$('#tableListPosts').empty();
			$('.div-list-posts').hide();
			clearCreatePostDiv();
			$('.div-create-post').hide();
			$('.div-show-post').hide();
			$('.div-blog-posts').hide();
			clearRegistrationDiv();
			$('.register-div').hide();
			clearLoginDiv();
			$('.login-div').show();
			$('.login-page').show();
		}
	});
});
