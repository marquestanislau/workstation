<div class="escalaos view">
<h2><?php echo __('Escalao'); ?></h2>
	<dl>
		<dt><?php echo __('Id'); ?></dt>
		<dd>
			<?php echo h($escalao['Escalao']['id']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Nome'); ?></dt>
		<dd>
			<?php echo h($escalao['Escalao']['nome']); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Categoria'); ?></dt>
		<dd>
			<?php echo $this->Html->link($escalao['Categoria']['id'], array('controller' => 'categorias', 'action' => 'view', $escalao['Categoria']['id'])); ?>
			&nbsp;
		</dd>
		<dt><?php echo __('Rclasse'); ?></dt>
		<dd>
			<?php echo $this->Html->link($escalao['Rclasse']['id'], array('controller' => 'rclasses', 'action' => 'view', $escalao['Rclasse']['id'])); ?>
			&nbsp;
		</dd>
	</dl>
</div>
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('Edit Escalao'), array('action' => 'edit', $escalao['Escalao']['id'])); ?> </li>
		<li><?php echo $this->Form->postLink(__('Delete Escalao'), array('action' => 'delete', $escalao['Escalao']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $escalao['Escalao']['id']))); ?> </li>
		<li><?php echo $this->Html->link(__('List Escalaos'), array('action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Escalao'), array('action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Categorias'), array('controller' => 'categorias', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Categoria'), array('controller' => 'categorias', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Rclasses'), array('controller' => 'rclasses', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Rclasse'), array('controller' => 'rclasses', 'action' => 'add')); ?> </li>
	</ul>
</div>
