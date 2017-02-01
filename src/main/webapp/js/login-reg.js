/**
 * 
 */

$(document).ready(function() {
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
		$('#uname').css('border','0px');
		$('#upassword').css('border','0px');
	}
	function clearRegistrationDiv() {
		$('#fullNameError').empty();
		$('#usernameError').empty();
		$('#pwdErr').empty();
		$('#cnfPwdErr').empty();
		$('#emailErr').empty();
		$('#phnErr').empty();
		$('#userExistsErr').empty();
		$('#fullNameError').hide();
		$('#usernameError').hide();
		$('#pwdErr').hide();
		$('#cnfPwdErr').hide();
		$('#phnErr').hide();
		$('#emailErr').hide();
		$('#userExistsErr').hide();
		$('#fullname').val('');
		$('#name').val('');
		$('#password').val('');
		$('#cnfpassword').val('');
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
	
	$('#registerhrf').click(function() {
		$('.login-div').css('display','none');
		$('.register-div').css('display','block');
	});
	$('#signinhrf').click(function() {
		clearLoginDiv();
		$('.login-div').css('display','block');
		clearRegistrationDiv();
		$('.register-div').css('display','none');
	});
	$('#loginhrf').click(function() {
		clearLoginDiv();
		$('.login-div').css('display','block');
		clearRegistrationDiv();
		$('.register-div').css('display','none');
		$('.success-reg-div').css('display','none');
	});
	$('#login').click(function() {
		var uname = $('#uname').val();
		var upassword = $('#upassword').val();
		if(!uname || uname == ''){
			$('#unameError').html('Please enter user name.').addClass('error-msg');
			$('#unameError').css('margin-bottom','10px');
			$('#unameError').show();
		}
		if(!upassword || upassword == ''){
			$('#upwdErr').html('Please enter password.').addClass('error-msg');
			$('#upwdErr').css('margin-bottom','10px');
			$('#upwdErr').show();
		}
		if(uname && upassword){
			var data = {
					userName : uname,
					password : upassword
				};
				$.ajax({
					url : 'online/user/authenticate/',
					type : 'post',
					contentType : 'application/json',
					accept : 'application/json',
					data : JSON.stringify(data),
					success : function(response) {
						clearLoginDiv();
						$('.login-div').css('display','none');
						$('.login-page').css('display','none');
						populatePosts(uname);
					},
					error : function(error) {
						var jsonObj = JSON.parse(error.responseText);
						$('#uname').val('');
						$('#upassword').val('');
						$('#uname').css('border','1px solid red');
						$('#upassword').css('border','1px solid red');
						$('#loginErr').html(jsonObj.httpStatusMessage).addClass('error-msg');
						$('#loginErr').css('margin-bottom','10px');
						$('#loginErr').show();
					}
				});
		}
	});
	$('#create').click(function() {
		var fullName = $('#fullname').val();
		var name = $('#name').val();
		var password = $('#password').val();
		var confirmPassword = $('#cnfpassword').val();
		var email = $('#email').val();
		var phoneNumber = $('#phonenumber').val();
		if(!fullName || fullName == ''){
			$('#fullNameError').html('Please enter full name.').addClass('error-msg');
			$('#fullNameError').css('margin-bottom','10px');
			$('#fullNameError').css('display','block');
			$('#fullNameError').show();
		}
		if(!name || name == ''){
			$('#usernameError').html('Please enter user name.').addClass('error-msg');
			$('#usernameError').css('margin-bottom','10px');
			$('#usernameError').css('display','block');
			$('#usernameError').show();
		}
		if(!password || password == ''){
			$('#pwdErr').html('Please enter password.').addClass('error-msg');
			$('#pwdErr').css('margin-bottom','10px');
			$('#pwdErr').css('display','block');
			$('#pwdErr').show();
		}
		if(!confirmPassword || confirmPassword == ''){
			$('#cnfPwdErr').html('Please enter confirm password.').addClass('error-msg');
			$('#cnfPwdErr').css('margin-bottom','10px');
			$('#cnfPwdErr').css('display','block');
			$('#cnfPwdErr').show();
		}
		if(!phoneNumber || phoneNumber == ''){
			$('#phnErr').html('Please enter phone number.').addClass('error-msg');
			$('#phnErr').css('margin-bottom','10px');
			$('#phnErr').css('display','block');
			$('#phnErr').show();
		}
		if(!email || email == ''){
			$('#emailErr').html('Please enter email.').addClass('error-msg');
			$('#emailErr').css('margin-top','10px');
			$('#emailErr').css('display','block');
			$('#emailErr').show();
		}
		if(password !== confirmPassword){
			$('#pwdErr').html('Password and confirm password not matching.').addClass('error-msg');
			$('#pwdErr').css('margin-bottom','10px');
			$('#pwdErr').css('display','block');
			$('#pwdErr').show();
		}
		if(fullName && name && password && confirmPassword && email){
			var data = {
				userName : name,
				fullName : fullName,
				password : password,
				email : email,
				phoneNumber : phoneNumber
			};
			$.ajax({
				url : 'online/user/',
				type : 'post',
				contentType : 'application/json',
				accept : 'application/json',
				data : JSON.stringify(data),
				success : function(response) {
					clearRegistrationDiv();
					$('#showFullName').html(fullName);
					$('#showUname').html(name);
					$('#showEmail').html(email);
					$('#showPhn').html(phoneNumber);
					$('.register-div').css('display','none');
					$('.success-reg-div').css('display','block');
				},
				error : function(error) {
					clearRegistrationDiv();
					$('#userExistsErr').html(JSON.parse(error.responseText).httpStatusMessage).addClass('error-msg');
					$('#userExistsErr').css('margin-bottom','10px');
					$('#userExistsErr').css('display','block');
					$('#userExistsErr').show();
				}
			});
		}
	});
	
	$('#name').on('keypress', function() {
		$('#usernameError').hide();
	});
	$('#password').on('keypress', function() {
		$('#pwdErr').hide();
	});
	$('#email').on('keypress', function() {
		$('#emailErr').hide();
	});
	$('#fullname').on('keypress', function() {
		$('#fullNameError').hide();
	});
	$('#cnfpassword').on('keypress', function() {
		$('#cnfPwdErr').hide();
	});
	$('#phonenumber').on('keypress', function() {
		$('#phnErr').hide();
	});
	$('#uname').on('keypress', function() {
		$('#unameError').hide();
	});
	$('#upassword').on('keypress', function() {
		$('#upwdErr').hide();
	});	
	
	function populatePosts(uname) {
		
		$.ajax({
			url : 'online/posts/',
			type : 'get',
			contentType : 'application/json',
			accept : 'application/json',
			success : function(response) {
				$('#tableListPosts').empty();
				if(typeof(response) != "undefined" && response != null){
					//$('.div-blog-user-details').html('Username : '+response.userName+', Email: '+response.email+', Phone number: '+response.phoneNumber);
					clearLoginDiv();
					clearRegistrationDiv();
					$('.login-div').hide();
					$('.register-div').hide();
					$('.login-page').hide();
					$('body').css('margin','0px');
					$('.div-create-post').hide();
					$('.div-show-post').hide();
					/*var users = [{
						'id' : '1',
						'view' : '0',
						'reply' : '0',
						'title' : 'Title Prasanna Title Prasanna Title Prasanna Title Prasanna Title Prasanna',
						'tags' : 'tags,tags,tags,tags,tags,tags',
						'user' : 'Prasanna Ramakrishna',
						'date' : 'Thu Jan 19 2017 19:12:21'
						},
						{
						'id' : '2',
						'view' : '1',
						'reply' : '1',
						'title' : 'Title Shruthi Title Shruthi Title Shruthi Title Shruthi',
						'tags' : 'tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags,tags',
						'user' : 'Shruthi Praanna',
						'date' : 'Thu Jan 19 2017 19:12:21'
						}];*/
					if(response.length > 0){
						window.posts = response;
						var i=0;
						var table = $('#tableListPosts');
						window.posts.forEach(function(post) {
							  var tr = $('<tr>');
							  /*tr.append('<td>' + user.name + '</td>');
							  table.append(tr);*/
							  var tagList = post.tags.split(',');
							  var j=0;
							  var anchorDt='';
							  tagList.forEach(function(tag){
								  if(tag.trim() !== ''){
									  anchorDt = anchorDt + '<a id="tags-'+i+j+'">'+tag.trim()+'</a>';
									  j=j+1;
								  }
							  });
							  anchorDt.trim();
							  tr.append('<div id="data-'+i+'"><div id="view-'+i+'"><div id="viewc-'+i+'">'+post.viewCount+'</div><div id="viewt-'+i+'">views</div></div><div id="reply-'+i+'"><div id="replyc-'+i+'">'+post.replyCount+'</div><div id="replyt-'+i+'">replies</div></div><div id="content-'+i+'"><div id="header-'+i+'">'+post.title+'<span style="display:none">'+post.postId+'</span></div><div id="footer-'+i+'"><div id="tagd-'+i+'">'+anchorDt+'</div><div id="footerright-'+i+'"><div id="date-'+i+'">'+new Date(post.createdDate).toString().split('G')[0].trim()+'</div><div id="untdet-'+i+'">'+post.createdBY+'</div></div></div></div></div>');
							  table.append(tr);
							  i=i+1;
						});
						$('.div-show-empty-posts').html('');
						$('.div-show-empty-posts').hide();
					}else{
						$('.div-show-empty-posts').html('NO POSTS AVAILABLE!');
						$('.div-show-empty-posts').show();
					}
					
					$('.div-blog-posts').show();
					$('.div-list-posts').show();
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
			},
			error : function(error) {
				console.log('Error: '+error);
			}
		});
	}
	
	var cookieUserName = document.cookie.split('=')[1];
	
	if(typeof(cookieUserName) != "undefined" && cookieUserName != null){
		console.log('cookieUserName: '+cookieUserName)
		populatePosts(cookieUserName);
	}

});